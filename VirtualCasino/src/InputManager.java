import java.util.Scanner;

/**
 * 
 * @author Nick
 *
 */

public class InputManager {
	public static int GetMenuOptionInput(int max) {
		Scanner scanner = new Scanner(System.in);

		int choice = -1;
		
		while(choice == -1) {
			System.out.print(">: ");
			String input = scanner.next();
			
			try {
				choice = Integer.parseInt(input);
				
				if(choice > max) {
					System.out.println(String.format("Invalid input. Please select a valid menu option (1-%s).", max));
					choice = -1;
				}
			} catch(Exception e) {
				System.out.println(String.format("Invalid input. Please select a numeric value listed above (1-%s).", max));
				choice = -1;
			}
			
		}
		return choice;
	}
}
