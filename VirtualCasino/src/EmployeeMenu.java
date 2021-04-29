
public class EmployeeMenu extends Menu {
	public EmployeeMenu(String id) {
		super(id);
	}
	
	@Override
	public void display() throws InterruptedException {
		clear();
		printBanner("Casino - Employee Main Menu");
		userPrint("Employee Terminal", "Please select an option below.");
		
		System.out.println("1. Check Machines.");
		System.out.println("2. Test Games.");
		System.out.println("3. Log out of Employee Terminal.");
		
		int choice = InputManager.getIntegerFromUser(3);
		
		switch(choice) {
		case 1:
			fixMenu();
			break;
		case 2:
			testGames();
			break;
		case 3:
			logOut();
			break;
		default:
			break;
		}
	}
	
	public void fixMenu() throws InterruptedException {
		clear();
		printBanner("Casino - Machine Status Menu");
		userPrint("Employee Terminal", "Checking Status of the Slot Machines.");
		
		sleep(3000);
		
		if()
		
		System.out.println("1. Slot Machines");
		System.out.println();
		
	}
	
	public void testGames() {
		
	}
	
	public void logOut() {
		
	}
	
	private void fixSlot() {
		
	}
	
	private void fixJack() {
		
	}
}
