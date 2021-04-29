import java.io.IOException;
import java.util.*;

/**
 * 
 * @author Nick, Matt, Ryan, Brandon
 *
 */

public class SlotMachineMenu extends Menu {
	private int money; //user's total money
	private Scanner input = new Scanner(System.in);
	private String grid[] = new String[9]; // used to hold the slot machine symbols 
	private String machineFace; //What gets displayed to the user when playing the slots
	private String[] standard = new String[] {"@", "#", "&", "%"}; // Standard symbols of the slot machine
	private String[] bonus = new String[] {"!", "$", "+"}; // Bonus symbols of the slot machine
	private int betAmount = 0; // User's bet
	
	/**
	 * Constructor.
	 * @param id The ID of the menu.
	*/
	public SlotMachineMenu(String id) {
		super(id);
		// The starting money.
		money = Casino.getPlayerMoney();
	}
	
	@Override
	public void display() throws InterruptedException {
		// Play the game.
		playGame();
	}

	/**
	 * Randomize a machine breaking.
	 * @throws InterruptedException
	 */
	//Machine breaking functionality 
	private void testMachine() throws InterruptedException {
		double randomNum = 1 + (Math.random() * 101);
		int chance = 5;
		
		//If the machine breaks it will report the broken machine and its ID
		if((int)randomNum <= chance) { 
			try {
				Casino.ReportBrokenMachine((int) Math.floor(1 + (Math.random() * 9999)) + "", "Machine Broken");
				
				//If the machine breaks the user will get an additional 500 dollars added to their total money
				userPrint("Manager", "Uh-oh! Looks like this machine is out of business! Sorry! Please use another machine.\nOur high tech software can transfer your session seamlessly to a new machine. We've also given you $500 for the inconvenience.");
				Casino.setPlayerMoney(Casino.getPlayerMoney() + 500);
				sleep(15000);
			} catch (IOException e) {
				System.out.println("File not created.");
			}
		}
	}
	
	/**
	 * Handles game logic.
	 * @throws InterruptedException
	 */
	private void playGame() throws InterruptedException {
		for(int i = 0; i < grid.length; ++i) {
			if(new Random().nextInt(2) == 1) {
				grid[i] = bonus[new Random().nextInt(bonus.length)];
			} else {
				grid[i] = standard[new Random().nextInt(standard.length)];
			}
			
		}
		
		clear();
		printBanner("Casino - Slot Machine");
		
		//Asks the user for their bet and takes their money that they input
		userPrint("Machine", String.format("You have $%s! Place your bet!", money));
		betAmount = InputManager.getIntegerFromUser(money);
		sleep(3000);
		
		clear();
		updateMachineFace();
		machinePrint(machineFace);
		animate();
		
		checkWin();
	}
	
	/**
	 * Check if we have won the game!
	 * @throws InterruptedException
	 */
	//Conditions for winning on the slot machine

	private void checkWin() throws InterruptedException {
		testMachine();
		
		boolean found = false;
		
		for(int i = 0; i < grid.length; i += 3) {
			if(grid[i].equals(grid[i + 1]) && grid[i].equals(grid[i + 2])) {
				
				//When the user gets 3 standard symbols they win the game and money is added to their total
				if(arrContains(standard, grid[i])) {
					money += betAmount;
					userPrint("Machine", String.format("You matched 3 standard icons! You now have $%s.", money));
					
				//When the user gets 3 bonus icons they win the game and money is added to their total 
				} else {
					money += betAmount * 4;
					userPrint("Machine", String.format("WOW! You matched 3 bonus icons! You now have $%s!", money));
				}
				found = true;
			}
 		}
		
		//If the user does not match 3 icons bonus or standard, they lose the game and money is taken from their account
		if(!found) {
			userPrint("Machine", "No matches! Want to play Again? (Yes / No)");
			money -= betAmount;
		}

		//Changes users money and asks if they would like to play again
		Casino.setPlayerMoney(money);
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		// If the user says yes the game restarts and runs once more
		if(choice.toUpperCase().compareTo("YES") == 0) {
			clear();
			printBanner("Casino - Slot Machine");
			userPrint("Machine", "Starting new game...");
			sleep(3000);
			goTo("SlotMachine");
			
		// If the user says no the game will end fully and return the user to the main lobby
		} else {
			clear();
			printBanner("Casino - Slot Machine");
			userPrint("Machine", "Thank you for your money - I mean time.");
			sleep(3000);
			goTo("Main");
		}
		
	}
	
	/**
	 * Check if the array contains the value specified.
	 * @param arr The array to check (String).
	 * @param val The value to search for (String).
	 * @return Boolean : Whether or not it was found.
	 */
	private boolean arrContains(String[] arr, String val) {
		for(String s : arr) {
			if(s.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Update the machine face when we animate.
	 */
	//Visually applies the symbols on the grid that the user sees in the terminal window
	private void updateMachineFace() {
		machineFace = "";
		
		for(int i = 0; i < grid.length; i += 3) {
			machineFace += String.format("%s %s %s\n", grid[i], grid[i + 1], grid[i + 2]);
		}
	}
	
	/**
	 * Animate the machine face.
	 * @throws InterruptedException
	 */
	//Gives the slot machine moving symbols
	private void animate() throws InterruptedException {
		
		// Animate 30 times
		for(int i = 0; i < 30; i++) {
			// Shift everything right once, 3 times
			for(int j = 0; j < 3; j++) {
				// Shift right once
				String temp = grid[grid.length - 1];
				for(int k = grid.length - 1; k > 0; k --) {
					grid[k] = grid[k - 1];
				}
				grid[0] = temp;
			}
			
			// Gradually sleep a longer amount
			sleep((int) (20 * (i / 2)));
			
			// Clear & display
			clear();
			printBanner("Casino - Slot Machine");
			updateMachineFace();
			machinePrint(machineFace);
		}
	}
}
