import java.util.Scanner;
/**
 * Menu subclass for the BlackJack game.
 * @author Nick, Matt, Ryan, Brandon
 *
 */
public class BlackjackMenu extends Menu {
	private int money;
	private Scanner input = new Scanner(System.in);
	
	
	/**
	 * Constructor.
	 * @param id The ID of the menu.
	 */
	public BlackjackMenu(String id) {
		super(id);
		
	}
	
	@Override
	public void display() throws InterruptedException {
		// Start the game
		playGame();
	}
	
	/**
	 * Displays the win information to the user.
	 * @param winnings The amount of money to give back to the user.
	 * @throws InterruptedException
	 */
	public void endGame(int winnings) throws InterruptedException {
		// Update the player's money.
		Casino.setPlayerMoney(money + winnings);
		
		// Display.
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You won the hand, here are your winnings. You now have $%s!", Casino.getPlayerMoney()));
		userPrint("Dealer", "Do you want to play again? (Yes / No)");
		
		// Try to play again.
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		// Either replay or go back to main.
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
	
	/**
	 * Handles game operations.
	 * @throws InterruptedException
	 */
	private void playGame() throws InterruptedException {
		// Store the player's current money.
		money = Casino.getPlayerMoney();
		
		// Calculate a starting hand.
		int card1 = (int) (1 + Math.random() * 10);
	    int card2 = (int) (1 + Math.random() * 10);
	    int cardTotal = card1 + card2;
	    
	    // Display & get bets.
	    clear();
	    printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("How much money would you like to bet?\nYou have $%s.", money));
		
		int betAmount = InputManager.getIntegerFromUser(money);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", "Bets have been placed!");
		sleep(3000);
			
		// Game loop
		if (cardTotal < 21) {	
			String response = "";
			while(!response.equals("STAND") && cardTotal < 21) {
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "What do you want to do? (Hit or Stand)\nCurrent hand: " + cardTotal + ".");
				response = InputManager.getChoiceFromUser(new String[] { "HIT", "STAND" });
				if (response.toUpperCase().equals("HIT")) {
					int card3 = (int) (1 + Math.random() * 10);
					cardTotal += card3;
					clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "The new total of yours cards is: " + cardTotal);
					sleep(3000);
				} else {
					// User wants to stand, calculate dealer hand
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
						endGame(betAmount);
				    } else if(cardTotal > dTotal) {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "I had " + dTotal + "!");
						sleep(3000);
						endGame(betAmount);
				    } else if(cardTotal < dTotal) {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "I had " + dTotal + "!");
						sleep(3000);
						endGame(-betAmount);
				    } else {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "Tie!");
				    }
					return;
				}
			}
		}
		
		// Bust or blackjack?
		if (cardTotal > 21) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Sorry, you busted. Try again!");
			endGame(-betAmount);
			return;
			
		} else if (cardTotal == 21) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Congratulations, you got blackjack!");
			sleep(3000);
			endGame(betAmount);
			return;
		}
	}
}
