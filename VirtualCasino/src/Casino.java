import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
	private static int playerMoney = 10000;
	
	
	/**
	 * Initializes the casino.
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void initialize() throws InterruptedException {
		menus = new Menu[] { new MainMenu("Main"), new GameSelectMenu("GameSelect"), new EmployeeLoginMenu("ELogin"), 
				new SlotMachineMenu("SlotMachine"), new BlackjackMenu("Blackjack"), new ExitMenu("Exit") };
		currentMenu = menus[0];
		
		currentMenu.display();
	}
	
	public static void updateMenu() throws InterruptedException {
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
	
	public static void ReportBrokenMachine(String id, String desc) throws IOException {
		File reports = new File("reports.txt");
		
		if(!reports.exists()) {
			reports.createNewFile();
		}

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
