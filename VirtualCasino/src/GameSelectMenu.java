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
	
	 //Gives user choice of what game to play
	public void display() throws InterruptedException {
		clear();
		printBanner("Casino - Game Lobby");
		userPrint("Game Lobby Sign", "Slot Machines - Left\n\t\t Blackjack Tables - Right\n\t\t Exit - Back");
		
	// Prompts user and asks for input on which game they would like to play
		System.out.println("Which way will you go?");
		String choice = InputManager.getChoiceFromUser(new String[] {"LEFT", "RIGHT", "BACK"}).toUpperCase();
		
		
		
		//Switch case for the user picking a game
		switch(choice) {
		
		/* Going left will bring the user to the Slot machines
		* This will cause the Slot machine menu to pop up
		*/
			case "LEFT":
				clear();
				System.out.println("You walk left towards the slot machines.");
				sleep(3000);
				goTo("SlotMachine");
				break;
				
		/* Going right will Bring the user to the Blackjack tables
		* This will cause the Blackjack menu to pop up
		*/	
			case "RIGHT":
				clear();
				System.out.println("You walk right towards the Blackjack table.");
				sleep(3000);
				goTo("Blackjack");
				break;
		
		/*
		 * Going back will bring the user back to the main menu / front desk person
		 */
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
