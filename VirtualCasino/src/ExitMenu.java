/**
 * Menu subclass for exiting the game.
 * @author Nick, Matt, Ryan, Brandon
 *
 */
public class ExitMenu extends Menu {
	/**
	 * Constructor
	 * @param id The ID of the menu.
	 */
	protected ExitMenu(String id) {
		super(id);
	}
	
	@Override
	//Exiting the casino from the main menu / front desk
	public void display() {
		clear();
		printBanner("Casino - Exit");
		userPrint("Front Desk Assistant", "Thank you for coming. Have a nice day!");
	}
	
}
