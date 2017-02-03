package seedu.addressbook.data.person.address;

/**
 * 
 * Represents the Postal Code of an address for a person
 *
 */
public class PostalCode {
	
	public final String value;
	
	public PostalCode(String value) {
		this.value = value;
	}
	
	/** Returns value for Postal Code */
	public String getValue() {
		return this.value;
	}

}
