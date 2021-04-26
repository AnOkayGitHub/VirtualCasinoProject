import java.util.*;

public class SlotMachineMenu extends Menu {
	private int money;
	private boolean isWorking;			//random chance for machine to break
	private Scanner input = new Scanner(System.in);
	
	public SlotMachineMenu(String id) {
		super(id);
		isWorking = true;
		money = 10000;
	}
	
	@Override
	public void display() throws InterruptedException {
		clear();
		printBanner("Casino - Slot Machine");
		userPrint("Front Desk Assistant", "Enjoy!");
	
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
		int grid[] = new int[9];
		int betAmmount = 0;
		for(int i = 0; i < grid.length; ++i)
			grid[i] = (int) (1 + Math.random() * 7);
		
		System.out.println("-------------------");
		System.out.println("|  " + grid[0] + "     " + grid[1] + "     " + grid[2] + "  |");
		System.out.println("|  " + grid[3] + "     " + grid[4] + "     " + grid[5] + "  |");
		System.out.println("|  " + grid[6] + "     " + grid[7] + "     " + grid[8] + "  |");
		System.out.println("-------------------");
		
		animate(grid);
		
		System.out.println("How much money would you like to bet: ");
		
		while(betAmmount == 0) {
			try {
				betAmmount = Integer.parseInt(input.nextLine());
			} catch(Exception e) {
				
			}
		}
		
		
		double randomNum;
		for(int i = 0; i < grid.length; ++i) {
			randomNum = 1 + (Math.random() * 8);
			grid[i] = (int)randomNum;
		}
		
		
	}
	
	private void animate(int[] grid) throws InterruptedException {
		
		for(int i = 0; i < 60; i++) {
			for(int j = 0; j < 3; j++) {
				int temp = grid[grid.length - 1];
				for(int k = grid.length - 1; k > 0; k --) {
					grid[k] = grid[k - 1];
				}
				grid[0] = temp;
			}
			
			sleep(150);
			clear();
			System.out.println("-------------------");
			System.out.println("|  " + grid[0] + "     " + grid[1] + "     " + grid[2] + "  |");
			System.out.println("|  " + grid[3] + "     " + grid[4] + "     " + grid[5] + "  |");
			System.out.println("|  " + grid[6] + "     " + grid[7] + "     " + grid[8] + "  |");
			System.out.println("-------------------");
		}
		
	}
	
}
