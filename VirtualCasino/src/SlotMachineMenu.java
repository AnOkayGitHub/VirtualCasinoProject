import java.util.*;

/**
 * 
 * @author Ryan, Nick
 *
 */

public class SlotMachineMenu extends Menu {
	private int money;
	private boolean isWorking;			//random chance for machine to break
	private Scanner input = new Scanner(System.in);
	private String grid[] = new String[9];
	private String machineFace;
	
	public SlotMachineMenu(String id) {
		super(id);
		isWorking = true;
		money = Casino.getPlayerMoney();
	}
	
	@Override
	public void display() throws InterruptedException {
		playGame();
	}
	
	private int winGame() {
		//UNFINISHED
		//most return money to user
		//user is not defined yet
		return money;
	}
	
	private void loseGame() {
		//will take money from user
		//UNFINISHED
		//user is not defined yet
	}

	private void breakMachine() {
/*		double randomNum = 1 + (Math.random() * 101);
		if((int)randomNum > 99) 
			isWorking = false;
			*/
		double randomNum = 1 + (Math.random() * 6);
		if((int)randomNum >= 3) 
			isWorking = false;
	}
	
	private void playGame() throws InterruptedException {
		
		String[] icons = new String[] {"!", "@", "#", "$", "&", "%", "+", "|"};
		for(int i = 0; i < grid.length; ++i) {
			grid[i] = icons[new Random().nextInt(icons.length)];
		}
		
		int betAmount = 0;
		clear();
		printBanner("Casino - Slot Machine");
		userPrint("Front Desk Assistant", "Enjoy!");
		
		
		updateMachineFace();
		machinePrint(machineFace);
		
		animate();
		
		userPrint("Machine", String.format("You have $%s! Place your bet!", money));
		betAmount = InputManager.getIntegerFromUser(money);
		
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
			userPrint("Front Desk Assistant", "Enjoy!");
			updateMachineFace();
			machinePrint(machineFace);
		}
	}
}
