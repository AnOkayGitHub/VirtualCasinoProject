
public class EmployeeLoginMenu extends Menu {
	protected EmployeeLoginMenu(String id) {
		super(id);
	}
	
	@Override
	public void display() {
		clear();
		printBanner("Casino - Employee Login Terminal");
		userPrint("Employee Portal", "Please enter your user ID below.");
		
		// 9999 is max for a 4 digit input
		int uid = InputManager.getIntegerFromUser(9999);
		
		userPrint("Employee Portal", "Please enter your PIN below.");
		int pin = InputManager.getIntegerFromUser(9999);
	}
}
