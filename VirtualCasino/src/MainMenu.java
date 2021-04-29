/**
 * Menu subclass that handles the Main Menu.
 * @author Nick, Ryan
 *
 */

public class MainMenu extends Menu {
	private static boolean hasEntered = false;
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
		int waitTime = 3000;
		
		if(!hasEntered) {
			// Clear and print display information
			clear();
			printBanner("Welcome to the Virtual Casino!");
			
			// Delay
			sleep(waitTime);
			
			clear();
			printBanner("Enjoy your stay! :)");
			
			sleep(waitTime);
			hasEntered = true;
		}
		
		clear();
		printBanner("Casino - Front Desk");
		userPrint("Front Desk Assistant", "How can I help you today?");
		
		// Menu to choose between playing a game, logging in as an employee or leaving the casino
		System.out.println("1. I'd like to play a game.");
		System.out.println("2. I need to log in to my Employee Account.");
		System.out.println("3. Goodbye!");
		
		int choice = InputManager.getIntegerFromUser(3);
		
		userPrint("Front Desk Assistant", "Right this way!");
		sleep(waitTime);
		
		// Will bring the user to either the games employee login or leaving casino based on their input of 1 2 or 3
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
