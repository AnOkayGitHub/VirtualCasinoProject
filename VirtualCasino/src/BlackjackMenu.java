/**
 * Menu subclass for the BlackJack game.
 * @author Nick, Matt, Ryan, Brandon
 *
 */
public class BlackjackMenu extends Menu {
	private int money;
	
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
	
	public void endGame(int winnings) throws InterruptedException {
		Casino.setPlayerMoney(money + winnings);
		
		if(winnings > 0) {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", String.format("You won the hand, here are your winnings. You now have $%s!", Casino.getPlayerMoney()));
		} else {
			clear();
			printBanner("Casino - Blackjack Table");
			userPrint("Dealer", String.format("You lost the hand. Thank you for your donation to the Casino. You now have $%s!", Casino.getPlayerMoney()));
		}
		
		sleep(2000);
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
		// Store the player's current money.
		money = Casino.getPlayerMoney();

		// First two cards are randomly generated and then assigned to an int that combines them
		int card1 = (int) (1 + Math.random() * 10);
	    int card2 = (int) (1 + Math.random() * 10);
	    int cardTotal = card1 + card2;
	    
	    // Display & get bets.
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
			
		// Game loop
		/*if the users cards are less than 21 the dealer asks if they would like to draw another card
		* or if they would like to stand
		*/
		if (cardTotal < 21) {	
			String response = "";
			while(!response.equals("STAND") && cardTotal < 21) {
				clear();
				printBanner("Casino - Blackjack Table");
				userPrint("Dealer", "What do you want to do? (Hit or Stand)\nCurrent hand: " + cardTotal + ".");
				
				//Receives user input if they would like to draw another card or stand
				response = InputManager.getChoiceFromUser(new String[] { "HIT", "STAND" });
				
				// If the user chose to hit they get another randomly generated card
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
						endGame(betAmount);
						 //Condition for the user winning by beating the dealer with no one busting
				    } else if(cardTotal > dTotal) {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "I had " + dTotal + "!");
						sleep(3000);
						endGame(betAmount);
						
						 //Condition for the dealer winning by beating the user with no one busting
				    } else if(cardTotal < dTotal) {
				    	clear();
						printBanner("Casino - Blackjack Table");
						userPrint("Dealer", "I had " + dTotal + "!");
						sleep(3000);
						endGame(-betAmount);
						
						//Condition for the user and the dealer getting the same number which results in a tie
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
			
			// Condition for winning and getting blackjack
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
