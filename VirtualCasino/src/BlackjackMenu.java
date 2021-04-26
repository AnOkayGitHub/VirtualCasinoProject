import java.util.Scanner;
/**
 * 
 * @author Matt, Nick
 *
 */
public class BlackjackMenu extends Menu {
	private int money;
	private boolean isWorking;			//random chance for machine to break
	private Scanner input = new Scanner(System.in);
	
	

	public BlackjackMenu(String id) {
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
	    
	    clear();
	    printBanner("Casino - Blackjack Table");
		userPrint("Dealer", "How much money would you like to bet?");
		
		betAmount = InputManager.GetIntegerFromUser(money);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", "The total of your two cards is: " + cardTotal + ".");
		
		while(isWorking = true) {
			
			if (cardTotal < 21) {	
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "Do you want to hit? (Yes/No)");
				
				String response = InputManager.GetChoiceFromUser(new String[] {"Yes", "No"});
				if (response.toUpperCase().equals(yes)) {
					int card3 = (int) (1 + Math.random() * 10);
					cardTotal += card3;
					clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "The new total of yours cards is: " + cardTotal);
					sleep(3000);
				} else {
					// User does NOT want a hit
					return;
				}
			
			} else if (cardTotal > 21) {
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "Sorry, you busted. Please try again.");
				loseGame();
				return;
				
			} else if (cardTotal == 21) {
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "Congratulations, you got blackjack!");
				return;
			}
		}
	}
}
