/**
 * Subclass For Game Select Menu
 */

/**
 * @author Nick
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
		System.out.println("Select a game: ");
	}

}
