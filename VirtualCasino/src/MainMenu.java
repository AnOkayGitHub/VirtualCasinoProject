

/**
 * Main Menu Child
 */

/**
 * @author Nick, Ryan
 *
 */

public class MainMenu extends Menu {
	
	/**
	 * Passes the ID to the superclass.
	 * @param id The ID of the menu.
	 */
	public MainMenu(String id) {
		super(id);
	}

	@Override
	public void display() throws InterruptedException {
		// Time between each menu clear (seconds)
		int waitTime = 1;
		
		// Clear and print display information
		clear();
		printBanner("Welcome to the Virtual Casino!");
		
		// Delay
		sleep(waitTime);
		
		clear();
		printBanner("Enjoy your stay! :)");
		
		sleep(waitTime);
		
		clear();
		printBanner("Casino - Front Desk");
		userPrint("Front Desk Assistant", "How can I help you today?");
		
		System.out.println("1. I'd like to play a game.");
		System.out.println("2. I need to log in to my Employee Account.");
		System.out.println("3. Goodbye!");
		
		int choice = InputManager.GetMenuOptionInput(3);
		
		userPrint("Front Desk Assistant", "Right this way!");
		sleep(waitTime);
		
		switch(choice) {
			case 1:
				goTo("GameSelect");
				break;
			case 2:
				goTo("ELogin");
				break;
			case 3:
				goTo("Exit");
				break;
			default:
				break;
		}
	}

}
