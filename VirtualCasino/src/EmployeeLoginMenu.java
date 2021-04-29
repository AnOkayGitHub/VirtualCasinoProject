
public class EmployeeLoginMenu extends Menu {
	String[] ids = new String[] { "1234", "0000", "9876", "8675" };
	String[] pins = new String[] { "1234", "1111", "5432", "3099" };
	String[] usernames = new String[] { "Nick", "Brandom", "Matt", "Ryan" };
	private boolean isLoggedIn = false;
	
	protected EmployeeLoginMenu(String id) {
		super(id);
	}
	
	@Override
	public void display() throws InterruptedException {
		clear();
		printBanner("Casino - Employee Login Terminal");
		userPrint("Employee Portal", "Please enter your user ID, then your PIN, below.");
		
		String uid = InputManager.getChoiceFromUser(4);
		String pin = InputManager.getChoiceFromUser(4);
		
		while(!validate(uid, pin)) {
			userPrint("Terminal", "Invalid Login. Please try again.");
			sleep(1500);	
			clear();
			printBanner("Casino - Employee Login Terminal");
			userPrint("Employee Portal", "Please enter your user ID, then your PIN, below.");
			
			uid = InputManager.getChoiceFromUser(4);
			pin = InputManager.getChoiceFromUser(4);
			
		}
		
		goTo("EMenu");
	}
	
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
