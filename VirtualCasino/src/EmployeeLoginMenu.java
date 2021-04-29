
// Declaring arrays for accepted usernames, Employee ID's and Employee pins
// Also sets whether or not an employee is logged in or not. By default no one is logged in
public class EmployeeLoginMenu extends Menu {
	String[] ids = new String[] { "1234", "0000", "9876", "8675" };
	String[] pins = new String[] { "1234", "1111", "5432", "3099" };
	String[] usernames = new String[] { "Nick", "Brandon", "Matt", "Ryan" };
	private boolean isLoggedIn = false;
	
	protected EmployeeLoginMenu(String id) {
		super(id);
	}
	
	
	@Override
	public void display() throws InterruptedException {
		clear();
		//Asks the user for their user ID and their pin then will accept user input
		printBanner("Casino - Employee Login Terminal");
		userPrint("Employee Portal", "Please enter your user ID, then your PIN, below.");
		
		//Takes employee ID and pin from user input
		String uid = InputManager.getChoiceFromUser(4);
		String pin = InputManager.getChoiceFromUser(4);
		
		// If the user does not provide correct credentials it will ask them to try again
		while(!validate(uid, pin)) {
			userPrint("Terminal", "Invalid Login. Please try again.");
			sleep(1500);	
			clear();
			printBanner("Casino - Employee Login Terminal");
			userPrint("Employee Portal", "Please enter your user ID, then your PIN, below.");
			
			//Takes employee ID and pin from user input
			uid = InputManager.getChoiceFromUser(4);
			pin = InputManager.getChoiceFromUser(4);
			
		}
		
		goTo("EMenu");
	}
	
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
