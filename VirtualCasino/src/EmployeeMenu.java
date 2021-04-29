
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
		
		/*if(broken machine exists) {
			then fix machine
			something like
			"Slot Machine is broken please go fix it"
			thinking maybe put this code in fixSlot()
		}
		else{
			print statement saying everything is working
			returning to Employee Menu
		}
		*/
		
		sleep(3000);
		display();
	}
	
	public void testGames() {
		
		
	}
	
	public void logOut() throws InterruptedException {
		clear();
		printBanner("Casino - Logging Out");
		userPrint("Employee Terminal", "Logging out. Please wait...");
		
		sleep(3000);
		
		userPrint("Employee Terminal", "Log out successful, Thank you.");
		
		sleep(1500);
		
		goTo("Main");
	}
	
	private void fixSlot() {
		
	}		
}
