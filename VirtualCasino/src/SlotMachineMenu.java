import java.io.IOException;
import java.util.*;

/**
 * 
 * @author Ryan, Nick
 *
 */

public class SlotMachineMenu extends Menu {
	private int money;
	private Scanner input = new Scanner(System.in);
	private String grid[] = new String[9];
	private String machineFace;
	private String[] standard = new String[] {"@", "#", "&", "%"};
	private String[] bonus = new String[] {"!", "$", "+"};
	private int betAmount = 0;
	
	public SlotMachineMenu(String id) {
		super(id);
		money = Casino.getPlayerMoney();
	}
	
	@Override
	public void display() throws InterruptedException {
		playGame();
	}

	private void testMachine() throws InterruptedException {
		double randomNum = 1 + (Math.random() * 101);
		int chance = 5;
		if((int)randomNum <= chance) { 
			try {
				Casino.ReportBrokenMachine((int) Math.floor(1 + (Math.random() * 9999)) + "", "Machine Broken");
				
				userPrint("Manager", "Uh-oh! Looks like this machine is out of business! Sorry! Please use another machine.\nOur high tech software can transfer your session seamlessly to a new machine. We've also given you $500 for the inconvenience.");
				Casino.setPlayerMoney(Casino.getPlayerMoney() + 500);
				sleep(15000);
			} catch (IOException e) {
				System.out.println("File not created.");
			}
		}
	}
	
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
		userPrint("Machine", String.format("You have $%s! Place your bet!", money));
		betAmount = InputManager.getIntegerFromUser(money);
		sleep(3000);
		
		clear();
		updateMachineFace();
		machinePrint(machineFace);
		animate();
		
		checkWin();
	}
	
	private void checkWin() throws InterruptedException {
		testMachine();
		
		boolean found = false;
		
		for(int i = 0; i < grid.length; i += 3) {
			if(grid[i].equals(grid[i + 1]) && grid[i].equals(grid[i + 2])) {
				if(arrContains(standard, grid[i])) {
					money += betAmount;
					userPrint("Machine", String.format("You matched 3 standard icons! You now have $%s.", money));
				} else {
					money += betAmount * 4;
					userPrint("Machine", String.format("WOW! You matched 3 bonus icons! You now have $%s!", money));
				}
				found = true;
			}
 		}
		
		if(!found) {
			userPrint("Machine", "No matches! Want to play Again? (Yes / No)");
			money -= betAmount;
		}
		
		
		
		Casino.setPlayerMoney(money);
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		if(choice.toUpperCase().compareTo("YES") == 0) {
			clear();
			printBanner("Casino - Slot Machine");
			userPrint("Machine", "Starting new game...");
			sleep(3000);
			goTo("SlotMachine");
		} else {
			clear();
			printBanner("Casino - Slot Machine");
			userPrint("Machine", "Thank you for your money - I mean time.");
			sleep(3000);
			goTo("Main");
		}
		
	}
	
	private boolean arrContains(String[] arr, String val) {
		for(String s : arr) {
			if(s.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	private void updateMachineFace() {
		machineFace = "";
		
		for(int i = 0; i < grid.length; i += 3) {
			machineFace += String.format("%s %s %s\n", grid[i], grid[i + 1], grid[i + 2]);
		}
		
	}
	
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
