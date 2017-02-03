package seedu.addressbook.data.person.address;

/**
 * 
 * Represents the Street of an address for a person 
 *
 */
public class Street {
	
    public final String value;
    
    public Street (String value) {
    	this.value = value;
    }
    
    /** Returns value of street */
    public String getValue() {
    	return this.value;
    }

}
