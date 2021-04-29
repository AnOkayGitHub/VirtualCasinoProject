import java.util.Scanner;

/**
 * 
 * @author Nick
 *
 */

public class InputManager {
	
	public static int getIntegerFromUser(int max) {
		Scanner scanner = new Scanner(System.in);

		int choice = -1;
		
		while(choice == -1) {
			System.out.print(">: ");
			String input = scanner.next();
			
			try {
				choice = Integer.parseInt(input);
				
				if(choice > max || choice <= 0) {
					System.out.println(String.format("Invalid input. Please input a valid option.", max));
					choice = -1;
				}
			} catch(Exception e) {
				System.out.println(String.format("Invalid input. Please input a numeric value.", max));
				choice = -1;
			}
			
		}
		return choice;
	}
	
	public static String getChoiceFromUser(String[] choices) {
		Scanner scanner = new Scanner(System.in);
		String choicesText = "";
		
		for(int i = 0; i < choices.length; i++) {
			choicesText += choices[i] + ", ";
		}
		
		String choice = "";
		
		while(choice.compareTo("") == 0) {
			System.out.print(">: ");
			choice = scanner.next();
			
			for(int i = 0; i < choices.length; i++) {
				if(choices[i].toLowerCase().compareTo(choice.toLowerCase()) == 0) {
					return choice;
				}
			}
			System.out.println(String.format("Invalid input. Please input a valid option. (%s)", choicesText));
			choice = "";
			
		}
		return choice;
	}
	
	public static String getChoiceFromUser(int len) {
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		
		while(choice.compareTo("") == 0) {
			System.out.print(">: ");
			choice = scanner.nextLine();
			
			try {
				int newChoice = Integer.parseInt(choice);
				
				if(choice.length() != len) {
					System.out.println(String.format("Invalid input. Please input a %s character value.", len));
					choice = "";
				} 
			} catch(Exception e) {
				System.out.println(String.format("Invalid input. Please input a %s character value.", len));
				choice = "";
			}
			
			
			
		}
		return choice;
	}
}
