package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
	
	public final String value;
    private boolean isPrivate;
    private static String contactValidationRegex;
    
    public Contact(String contact, boolean isPrivate, String contactValidationRegex, String messageConstraints) throws IllegalValueException {
    	String trimmedContact = contact.trim();
    	this.isPrivate = isPrivate;
    	this.contactValidationRegex = contactValidationRegex;
    	if (!isValidContact(trimmedContact)) {
    		throw new IllegalValueException(messageConstraints);
    	}
    	this.value = trimmedContact;
    }
    
    /**
     * Returns true if given string is a valid contact
     */
    public static boolean isValidContact(String test) {
    	return test.matches(contactValidationRegex);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
