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
		System.out.println("Select a game: ");
	}

}
