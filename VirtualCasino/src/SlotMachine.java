import java.util.*;

public class SlotMachine extends Machine {
	private int money;
	private boolean isWorking;			//random chance for machine to break
	private Scanner input = new Scanner(System.in);
	
	public SlotMachine(int someMoney) {
		money = someMoney;
		isWorking = true;
	}
	
	public int winGame() {
		//UNFINISHED
		//most return money to user
		//user is not defined yet
		return money;
	}
	
	public void loseGame() {
		//will take money from user
		//UNFINISHED
		//user is not defined yet
	}

	public void breakMachine() {
/*		double randomNum = 1 + (Math.random() * 101);
		if((int)randomNum > 99) 
			isWorking = false;
			*/
		double randomNum = 1 + (Math.random() * 6);
		if((int)randomNum >= 3) 
			isWorking = false;
	}
	
	public void playGame() {
		int grid[] = new int[9];
		int betAmmount = 0;
		for(int i = 0; i < grid.length; ++i)
			grid[i] = 0;
		
		System.out.println("-------------------");
		System.out.println("|  " + grid[0] + "     " + grid[1] + "     " + grid[2] + "  |");
		System.out.println("|  " + grid[3] + "     " + grid[4] + "     " + grid[5] + "  |");
		System.out.println("|  " + grid[6] + "     " + grid[7] + "     " + grid[8] + "  |");
		System.out.println("-------------------");
		
		System.out.println("How much money would you like to bet: ");
		
		while(betAmmount = 0) {
			try {
				betAmmount = input.nextLine();
			}catch(Exception e)
		}
		
		
		double randomNum;
		for(int i = 0; i < grid.length; ++i) {
			randomNum = 1 + (Math.random() * 8);
			grid[i] = (int)randomNum;
		}
		
		
	}
	
}
