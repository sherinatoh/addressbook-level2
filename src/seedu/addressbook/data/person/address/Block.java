package seedu.addressbook.data.person.address;

/**
 * Represents the block of an address for a person
 * 
 */
public class Block {
	
    public final String value;
    
    public Block (String value) {
    	this.value = value;
    }
    
    /** Returns value for Block */
    public String getValue() {
    	return this.value;
    }
	
}
