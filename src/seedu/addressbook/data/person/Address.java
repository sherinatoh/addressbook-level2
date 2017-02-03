package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;
import seedu.addressbook.data.person.address.PostalCode;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses entered in following format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLIT_REGEX = ", ";
    
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTALCODE_INDEX = 3;

    public final String value;
    private boolean isPrivate;
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        
        String[] splitAddress = trimmedAddress.split(ADDRESS_SPLIT_REGEX); 
        
        if (!isValidAddress(splitAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.block = new Block(splitAddress[BLOCK_INDEX]);
        this.street = new Street(splitAddress[STREET_INDEX]);
        this.unit = new Unit(splitAddress[UNIT_INDEX]);
        this.postalCode = new PostalCode(splitAddress[POSTALCODE_INDEX]);
        
        this.value = block.getValue() + ADDRESS_SPLIT_REGEX + street.getValue() + ADDRESS_SPLIT_REGEX +
        		unit.getValue() + ADDRESS_SPLIT_REGEX + postalCode.getValue();
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String[] test) {
    	if (test.length != 4) {
    		return false;
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		if (!test[i].matches(ADDRESS_VALIDATION_REGEX)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    /** Returns Address block */
    public String getBlock() {
    	return block.getValue();
    }
    
    /** Returns Address street */
    public String getStreet() {
    	return street.getValue();
    }
    
    /** Returns Address unit */
    public String getUnit() {
    	return unit.getValue();
    }
    
    /** Returns Address postal code */
    public String getPostalCode() {
    	return postalCode.getValue();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
