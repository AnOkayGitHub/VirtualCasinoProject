import java.util.Scanner;

public class Blackjack extends Menu {
	private int money;
	private boolean isWorking;			//random chance for machine to break
	private Scanner input = new Scanner(System.in);
	
	

	public Blackjack(String id) {
		super(id);
		isWorking = true;
		money = 10000;
	}
		@Override
	public void display() throws InterruptedException {
			playGame();
		
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
	
	private void playGame() throws InterruptedException {
		String yes = "YES";
		String no = "NO";
		int card1 = (int) (1 + Math.random() * 10);
	    int card2 = (int) (1 + Math.random() * 10);
	    int betAmount = 0;
	    int cardTotal = card1 + card2;
	    
		System.out.println("How much money would you like to bet: ");
		
		while(betAmount == 0) {
			try {
				betAmount = Integer.parseInt(input.nextLine());
			}catch(Exception e) {
				
			}
		}
		System.out.println("The total of your two cards is: " + cardTotal);
		
		while(isWorking = true) {
		if (cardTotal < 21) {	
		System.out.println("Do you want to hit? Say YES or NO.");
		String response = input.nextLine();
			if (response.equals(yes)) {
				int card3 = (int) (1 + Math.random() * 10);
				cardTotal += card3;
				System.out.println("The new total of yours cards is: " + cardTotal);
				
			}
		
		} else if (cardTotal > 21) {
		System.out.println("Sorry, you busted. Please try again.");
		loseGame();
		
		}else if (cardTotal == 21) {
		System.out.println("Congratulations, you got blackjack!");
	}
		
}
}
}
