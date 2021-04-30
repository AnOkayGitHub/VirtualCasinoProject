/**
 * Menu subclass for the Employee Portal login.
 * @author Nick, Matt, Ryan, Brandon
 *
 */

// Declaring arrays for accepted usernames, Employee ID's and Employee pins
// Also sets whether or not an employee is logged in or not. By default no one is logged in
public class EmployeeLoginMenu extends Menu {
	String[] ids = new String[] { "1234", "1111", "9876", "8675" };
	String[] pins = new String[] { "1234", "2222", "5432", "3099" };
	String[] usernames = new String[] { "Nick", "Brandon", "Matt", "Ryan" };
	private boolean isLoggedIn = false;
	
	/**
	 * Constructor.
	 * @param id The ID of the menu.
	 */
	protected EmployeeLoginMenu(String id) {
		super(id);
	}
	
	
	@Override
	public void display() throws InterruptedException {
		clear();
		//Asks the user for their user ID and their pin then will accept user input
		printBanner("Casino - Employee Login Terminal");
		userPrint("Employee Portal", "Please enter your user ID, then your PIN, below. Enter '0000' to return.");
		
		//Takes employee ID and pin from user input
		String uid = InputManager.getChoiceFromUser(4);
		
		if(uid.compareTo("0000") == 0) {
			clear();
			printBanner("Casino - Employee Login Terminal");
			userPrint("Employee Portal", "Exiting...");
			sleep(1500);	
			goTo("Main");
		}
		
		String pin = InputManager.getChoiceFromUser(4);
		
		// If the user does not provide correct credentials it will ask them to try again
		while(!validate(uid, pin)) {
			userPrint("Terminal", "Invalid Login. Please try again.");
			sleep(1500);	
			clear();
			printBanner("Casino - Employee Login Terminal");
			userPrint("Employee Portal", "Please enter your user ID, then your PIN, below. Enter '0000' to return.");
			
			//Takes employee ID and pin from user input
			uid = InputManager.getChoiceFromUser(4);
			
			if(uid.compareTo("0000") == 0) {
				clear();
				printBanner("Casino - Employee Login Terminal");
				userPrint("Employee Portal", "Exiting...");
				sleep(1500);	
				goTo("Main");
			}
			pin = InputManager.getChoiceFromUser(4);
		}
		goTo("EMenu");
	}
	
	/**
	 * Validate a login.
	 * @param id The UID of the user.
	 * @param p The PIN of the user.
	 * @return boolean : whether or not the login was successful.
	 * @throws InterruptedException
	 */
	//Will set the system to logged in once the employee has entered their information in correctly
	private boolean validate(String id, String p) throws InterruptedException {
		isLoggedIn = false;
		for(int i = 0; i < ids.length; i++) {
			if(id.equals(ids[i]) && p.equals(pins[i])) {
				isLoggedIn = true;
				userPrint("Terminal", "Welcome to the Employee Portal, " + usernames[i] + ".");
				sleep(3000);
				return isLoggedIn;
			}
		}
		return isLoggedIn;
	}
}
