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
		money = Casino.getPlayerMoney();
	}
		@Override
	public void display() throws InterruptedException {
			playGame();
		
	}
	public void winGame(int winnings) {
		Casino.setPlayerMoney(money + winnings);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You won the hand, here are your winnings. You now have $%s!", Casino.getPlayerMoney()));
	}
	
	public void loseGame(int losingAmount) {
		Casino.setPlayerMoney(money - losingAmount);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You lost the hand, I'll be taking your money. You now have $%s!", Casino.getPlayerMoney()));
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
		int card1 = (int) (1 + Math.random() * 10);
	    int card2 = (int) (1 + Math.random() * 10);
	    int cardTotal = card1 + card2;
	    
	    clear();
	    printBanner("Casino - Blackjack Table");
		userPrint("Dealer", "How much money would you like to bet?");
		
		int betAmount = InputManager.getIntegerFromUser(money);

		
		while(isWorking = true) {
			
			if (cardTotal < 21) {	
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "What do you want to do? (Hit or Stand)\nCurrent hand: " + cardTotal + ".");
				
				String response = InputManager.getChoiceFromUser(new String[] { "HIT", "STAND" });
				if (response.toUpperCase().equals("HIT")) {
					int card3 = (int) (1 + Math.random() * 10);
					cardTotal += card3;
					clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "The new total of yours cards is: " + cardTotal);
					sleep(3000);
				} else {
					// User wants to stand
					int dCard1 = (int) (1 + Math.random() * 10);
				    int dCard2 = (int) (1 + Math.random() * 10);
				    int dTotal = dCard1 + dCard2;
				    
				    while(dTotal < 17) {
				    	int dCard3 = (int) (1 + Math.random() * 10);
				    	dTotal += dCard3;
				    }
				    
				    if(dTotal > 21 && cardTotal < 21) {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "I Busted! I had " + dTotal + "!");
						sleep(3000);
						winGame(betAmount * 5);
				    } else if(cardTotal > dTotal) {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "I had " + dTotal + "!");
						sleep(3000);
						winGame(betAmount * 5);
				    } else if(cardTotal < dTotal) {
						loseGame(betAmount * 5);
				    } else {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "Tie!");
				    }
					return;
				}
			
			} else if (cardTotal > 21) {
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "Sorry, you busted. Try again!");
				loseGame(betAmount * 5);
				return;
				
			} else if (cardTotal == 21) {
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "Congratulations, you got blackjack!");
				sleep(3000);
				winGame(betAmount * 5);
				return;
			}
		}
	}
}
