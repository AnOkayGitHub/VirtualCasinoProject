import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles Casino logic.
 * 
 * @author Nick, Matt, Ryan, Brandon
 *
 */
public class Casino {
	private static Menu[] menus;				// An array of all menus in the program.
	private static Menu currentMenu;			// The current menu we are in.
	private static int playerMoney = 10000;		// The player's starting money.
	
	
	/**
	 * Initializes the casino.
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void initialize() throws InterruptedException {
		// Initialize menus and displays the starting menu.
		menus = new Menu[] { new MainMenu("Main"), new GameSelectMenu("GameSelect"), new EmployeeLoginMenu("ELogin"), 
				new SlotMachineMenu("SlotMachine"), new BlackjackMenu("Blackjack"), new ExitMenu("Exit"), 
				new EmployeeMenu("EMenu")};
		currentMenu = menus[0];
		
		currentMenu.display();
	}
	
	/**
	 * Update the current menu.
	 * @throws InterruptedException
	 */
	public static void updateMenu() throws InterruptedException {
		currentMenu.display();
	}
	
	/**
	 * Get a menu from an ID.
	 * @param id The ID to search for.
	 * @return A Menu matching the ID, null if not found.
	 */
	public static Menu getMenuFromID(String id) {
		for(int i = 0; i < menus.length; i++) {
			if(menus[i].getID().compareTo(id) == 0) {
				return menus[i];
			}
		}
		return null;
	}
	
	// Creates a text file for broken machines
	public static void ReportBrokenMachine(String id, String desc) throws IOException {
		File reports = new File("reports.txt");
		
		//If the file does not exist already it will create the file
		if(!reports.exists()) {
			reports.createNewFile();
		}

		//If the machine is broken it writes the machines id and reason its down to a text file
		FileWriter writer = new FileWriter(reports, true);
		writer.append("Machine ID #" + id + " is down for: " + desc + ".\n");
		writer.close();
	}
	
	/**
	 * Getters & Setters for the menu and player money
	 */
	
	public static Menu getCurrentMenu() {
		return currentMenu;
	}
	
	public static void setCurrentMenu(String id) {
		currentMenu = getMenuFromID(id);
	}
	
	public static int getPlayerMoney() {
		return playerMoney;
	}
	
	public static void setPlayerMoney(int newVal) {
		playerMoney = newVal;
	}
}
