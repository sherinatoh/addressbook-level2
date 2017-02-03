package seedu.addressbook.data.person.address;

/**
 * 
 * Represents the unit of an address for a person 
 *
 */
public class Unit {
	
	public final String value;
	
	public Unit (String value) {
		this.value = value;
	}
	
	/** Returns value of the unit */
	public String getValue() {
		return this.value;
	}

}
