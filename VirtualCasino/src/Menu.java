import java.io.IOException;

/**
 * Superclass for menus
 */

/**
 * @author Nick
 *
 */
public class Menu implements MenuAttributes {
	protected String id;
	
	/**
	 * Constructor
	 * @param id The ID of the menu.
	 */
	protected Menu(String id) {
		this.id = id;
	}
	
	/**
	 * Clears the console by printing many empty lines.
	 */
	protected void clear() {
		for(int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}
	
	/**
	 * Prints a banner message surrounded by bars.
	 * @param message The message to print.
	 */
	protected void printBanner(String message) {
		String bar = "--------------------------------------------------";
		System.out.println(String.format("%s\n%s\n%s", bar, message, bar));
	}
	
	/**
	 * Prints a message as the program speaking to the user.
	 * @param speaker
	 * @param message
	 */
	protected void userPrint(String speaker, String message) {
		System.out.println(String.format("\n%s: %s\n", speaker, message));
	}

	@Override
	public void goTo(String target) {
		System.out.println("This should not be called!");
	}

	@Override
	public void display() throws InterruptedException {
		System.out.println("If you are seeing this you messed up.");
		
	}

	@Override
	public String getID() {
		return id;
	}
}
