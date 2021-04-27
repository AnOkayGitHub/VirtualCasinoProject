/**
 * Subclass For Game Select Menu
 */

/**
 * @author Nick, Ryan
 *
 */

public class GameSelectMenu extends Menu {
	
	/**
	 * Constructor, passes id to superclass.
	 * @param id The ID of the menu.
	 */
	public GameSelectMenu(String id) {
		super(id);
	}

	@Override
	public void display() throws InterruptedException {
		clear();
		printBanner("Casino - Game Lobby");
		userPrint("Game Lobby Sign", "Slot Machines - Left\n\t\t Blackjack Tables - Right\n\t\t Exit - Back");
		
		System.out.println("Which way will you go?");
		String choice = InputManager.getChoiceFromUser(new String[] {"LEFT", "RIGHT", "BACK"}).toUpperCase();
		
		switch(choice) {
			case "LEFT":
				clear();
				System.out.println("You walk left towards the slot machines.");
				sleep(3000);
				goTo("SlotMachine");
				break;
			case "RIGHT":
				clear();
				System.out.println("You walk right towards the Blackjack table.");
				sleep(3000);
				goTo("Blackjack");
				break;
			case "BACK":
				clear();
				System.out.println("You walk back to the front desk.");
				sleep(3000);
				goTo("Main");
				break;
			default:
				break;
		}	
	}

}
