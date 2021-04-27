import java.util.Scanner;
/**
 * 
 * @author Matt, Nick
 *
 */
public class BlackjackMenu extends Menu {
	private int money;
	private Scanner input = new Scanner(System.in);
	
	
/*
 * Calls the menu super class
 */
	public BlackjackMenu(String id) {
		super(id);
		
	}
	
	@Override
	public void display() throws InterruptedException {
		playGame();
	}
		
	/*
	 * Condition for winning blackjack
	 * Combines users current money with the money the user has just won
	 * Updates the users total amount and asks if they would like to play again
	 */
	public void winGame(int winnings) throws InterruptedException {
		Casino.setPlayerMoney(money + winnings);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You won the hand, here are your winnings. You now have $%s!", Casino.getPlayerMoney()));
		userPrint("Dealer", "Do you want to play again? (Yes / No)");
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		// If user enters yes for a rematch it goes back to replay the game
		if(choice.toUpperCase().compareTo("YES") == 0) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "So you want a rematch, huh?!");
			sleep(3000);
			goTo("Blackjack");
			
			// If user enters no it will return you to the main menu
		} else {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Thanks for playing!");
			sleep(3000);
			goTo("Main");
		}
		
	}
	
	/*
	 * Condition for losing blackjack
	 * Subtracts users current money with the amount they bet on the game
	 * Updates the users total amount and asks if they would like to play again
	 */
	public void loseGame(int losingAmount) throws InterruptedException {
		Casino.setPlayerMoney(money - losingAmount);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", String.format("You lost the hand, I'll be taking your money. You now have $%s!", Casino.getPlayerMoney()));
		userPrint("Dealer", "Do you want to play again? (Yes / No)");
		String choice = InputManager.getChoiceFromUser(new String[] {"YES", "NO"});
		
		// If user enters yes for a rematch it goes back to replay the game
		if(choice.toUpperCase().compareTo("YES") == 0) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "So you want a rematch, huh?!");
			sleep(3000);
			goTo("Blackjack");
			
			// If user enters no it will return you to the main menu
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
		
		// First two cards are randomly generated and then assigned to an int that combines them
		int card1 = (int) (1 + Math.random() * 10);
	    int card2 = (int) (1 + Math.random() * 10);
	    int cardTotal = card1 + card2;
	    
	    clear();
	    printBanner("Casino - Blackjack Table");
	    
	    //Shows user their total money and asks how much they want to bet
		userPrint("Dealer", String.format("How much money would you like to bet?\nYou have $%s.", money));
		
		//Recieves user bet
		int betAmount = InputManager.getIntegerFromUser(money);
		
		clear();
		printBanner("Casino - Blackjack Table");
		userPrint("Dealer", "Bets have been placed!");
		sleep(3000);
			
		/*if the users cards are less than 21 the dealer asks if they would like to draw another card
		* or if they would like to stand
		*/
		if (cardTotal < 21) {	
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "What do you want to do? (Hit or Stand)\nCurrent hand: " + cardTotal + ".");
			
			//Recieves user input if they would like to draw another card or stand
			String response = InputManager.getChoiceFromUser(new String[] { "HIT", "STAND" });
			
			// If the user chose to hit they get another randomly generated card
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
			    
			    // If the dealer's cards are under 17 they draw a third card 
			    while(dTotal < 17) {
			    	int dCard3 = (int) (1 + Math.random() * 10);
			    	dTotal += dCard3;
			    }
			    
			    //Condition for just the Dealer busting and user winning the game
			    if(dTotal > 21 && cardTotal < 21) {
			    	clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "I Busted! I had " + dTotal + "!");
					sleep(3000);
					winGame(betAmount );
					
				    //Condition for the user winning by beating the dealer with no one busting
			    } else if(cardTotal > dTotal) {
			    	clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "I had " + dTotal + "!");
					sleep(3000);
					winGame(betAmount );
					
					 //Condition for the dealer winning by beating the user with no one busting
			    } else if(cardTotal < dTotal) {
			    	clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "I had " + dTotal + "!");
					sleep(3000);
					loseGame(betAmount );
					
					//Condition for the user and the dealer getting the same number which results in a tie
			    } else {
			    	clear();
					printBanner("Casino - Blackjack Table");
					userPrint("Dealer", "Tie!");
			    }
				return;
			}
		
			// Condition for losing the game by going over 21 
		} else if (cardTotal > 21) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", "Sorry, you busted. Try again!");
			loseGame(betAmount );
			return;
			
			// Condition for winning and getting blackjack
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
