package seedu.addressbook.ui;

/**
 * 
 * Class that handles the formatting
 *
 */
public class Formatter {
	
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    
    private static final String DIVIDER = "===================================================";
    
    /** Adding a line prefix before a string */
    public static String addLinePrefix(String string) {
    	return LINE_PREFIX + string;
    }
    
    /** Appending a divider after a string */
    public static String appendDivider (String string, int number) {
    	String result = string;
    	
    	for (int i = 0; i < number; i++) {
    		result = result + DIVIDER;
    	}
		return result;
    }
    
    public static String formatWelcomeMessage(String string) {
    	return DIVIDER + DIVIDER + string + DIVIDER;
    }
    
    /** Formatting for showToUsers */
    public static String formatShowToUsers(String message) {
    	return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }

}
