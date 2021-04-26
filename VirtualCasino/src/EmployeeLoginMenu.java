
public class EmployeeLoginMenu extends Menu {
	protected EmployeeLoginMenu(String id) {
		super(id);
	}
	
	@Override
	public void display() {
		clear();
		printBanner("Casino - Employee Login Terminal");
		userPrint("Employee Portal", "Please enter your user ID below.");
		int uid = InputManager.GetMenuOptionInput(-1);
		
		userPrint("Employee Portal", "Please enter your PIN below.");
		int pin = InputManager.GetMenuOptionInput(-1);
	}
}
