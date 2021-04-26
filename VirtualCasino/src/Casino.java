/**
 *  Handles Casino Logic
 */

/**
 * @author Nick, Ryan
 *
 */
public class Casino {
	private static Menu[] menus;
	private static Menu currentMenu;
	
	
	
	/**
	 * Initializes the casino.
	 * @throws InterruptedException
	 */
	public static void Initialize() throws InterruptedException {
		menus = new Menu[] { new MainMenu("Main"), new GameSelectMenu("GameSelect") };
		currentMenu = menus[0];
		
		currentMenu.display();
	}
	
	public static void UpdateMenu() throws InterruptedException {
		currentMenu.display();
	}
	
	public static Menu getMenuFromID(String id) {
		
		for(int i = 0; i < menus.length; i++) {
			if(menus[i].getID().compareTo(id) == 0) {
				return menus[i];
			}
		}
		
		return null;
	}
	
	public static Menu getCurrentMenu() {
		return currentMenu;
	}
	
	public static void setCurrentMenu(String id) {
		currentMenu = getMenuFromID(id);
	}
}
