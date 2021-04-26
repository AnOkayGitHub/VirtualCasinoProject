import java.util.concurrent.TimeUnit;

/**
 * Superclass for menus
 */

/**
 * @author Nick, Ryan
 *
 */
public class Menu implements MenuAttributes {
	// Protected string to hold the ID of the menu
	protected String id;
	
	/**
	 * Constructor
	 * @param id The ID of the menu.
	 */
	protected Menu(String id) {
		this.id = id;
	}
	
	/**
	 * Mimics clearing the console by printing many empty lines.
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
	public void goTo(String target) throws InterruptedException {
		Casino.setCurrentMenu(target);
		Casino.UpdateMenu();
	}

	@Override
	public void display() throws InterruptedException {
		System.out.println("This should not be called either.");
	}

	@Override
	public String getID() {
		return id;
	}
	
	@Override
	public void sleep(int waitTime) throws InterruptedException {
		TimeUnit.SECONDS.sleep(waitTime);
	}
}
