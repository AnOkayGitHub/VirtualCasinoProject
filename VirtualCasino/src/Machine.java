/**
 * 
 */

/**
 * @author Ryan Bruhn
 *
 */
public abstract class Machine {
	private int money;
	private boolean isWorking;			//random chance for machine to break
	
	public Machine(int someMoney) {
		money = someMoney;
		isWorking = true;
	}
	
	public void playGame() {
	}
	
	public int winGame() {
		return money;
	}
	
	public void loseGame() {
		//will take money from user
	}

	public void breakMachine() {
		//runs everytime at the end of playGame
		//to see if machine breaks
	}
	
}
