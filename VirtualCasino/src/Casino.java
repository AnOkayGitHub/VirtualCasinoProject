import java.io.IOException;

/**
 *  Handles Casino Logic
 */

/**
 * @author Nick
 *
 */
public class Casino {
	private static Menu[] menus;
	
	/**
	 * Initializes the casino.
	 * @throws InterruptedException
	 */
	public static void Initialize() throws InterruptedException {
		menus = new Menu[] { new MainMenu("Main"), new GameSelectMenu("GameSelect") };
		menus[0].display();
	}
}
