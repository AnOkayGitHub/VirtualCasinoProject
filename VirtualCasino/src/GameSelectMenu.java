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
	public void display() {
		clear();
		printBanner("Casino - Game Select Lobby");
		userPrint("Front Desk Assistant", "Which game would you like to play?");
		
		System.out.println("1. Slot Machine");
		System.out.println("2. Blackjack.");
	}

}
