import java.util.Scanner;
/**
 * 
 * @author Matt, Nick
 *
 */
public class BlackjackMenu extends Menu {
	private int money;
	private Scanner input = new Scanner(System.in);
	
	

	public BlackjackMenu(String id) {
		super(id);
		
	}
	
	@Override
	public void display() throws InterruptedException {
		playGame();
	}
		
	public void winGame(int winnings) throws InterruptedException {
		Casino.setPlayerMoney(money + winnings);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You won the hand, here are your winnings. You now have $%s!", Casino.getPlayerMoney()));
		userPrint("Dealer", "Do you want to play again? (Yes / No)");
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		if(choice.toUpperCase().compareTo("YES") == 0) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "So you want a rematch, huh?!");
			sleep(3000);
			goTo("Blackjack");
		} else {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Thanks for playing!");
			sleep(3000);
			goTo("Main");
		}
		
	}
	
	public void loseGame(int losingAmount) throws InterruptedException {
		Casino.setPlayerMoney(money - losingAmount);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You lost the hand, I'll be taking your money. You now have $%s!", Casino.getPlayerMoney()));
		userPrint("Dealer", "Do you want to play again? (Yes / No)");
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		if(choice.toUpperCase().compareTo("YES") == 0) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "So you want a rematch, huh?!");
			sleep(3000);
			goTo("Blackjack");
		} else {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Thanks for playing!");
			sleep(3000);
			goTo("Main");
		}
	}
	
	private void playGame() throws InterruptedException {
		money = Casino.getPlayerMoney();
		
		int card1 = (int) (1 + Math.random() * 10);
	    int card2 = (int) (1 + Math.random() * 10);
	    int cardTotal = card1 + card2;
	    
	    clear();
	    printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("How much money would you like to bet?\nYou have $%s.", money));
		
		int betAmount = InputManager.getIntegerFromUser(money);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", "Bets have been placed!");
		sleep(3000);
			
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
					winGame(betAmount );
			    } else if(cardTotal > dTotal) {
			    	clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "I had " + dTotal + "!");
					sleep(3000);
					winGame(betAmount );
			    } else if(cardTotal < dTotal) {
			    	clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "I had " + dTotal + "!");
					sleep(3000);
					loseGame(betAmount );
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
			loseGame(betAmount );
			return;
			
		} else if (cardTotal == 21) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Congratulations, you got blackjack!");
			sleep(3000);
			winGame(betAmount );
			return;
		}
	}
}
