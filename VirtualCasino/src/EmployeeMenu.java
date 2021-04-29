import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Menu subclass for the Employee's menu.
 * @author Nick, Matt, Ryan, Brandon
 *
 */

public class EmployeeMenu extends Menu {
	
	ArrayList<String> machinesToFix = new ArrayList<String>();
	
	// Array for Employee dialog when fixing machine
	String[] fixPrompts = new String[] { "The spin button seems stuck...", "Need a new cash validator!", "A crack in the screen!",
			"This one is falling apart.", "How did that even happen?", "The LEDs are kinda dim.", "I need a new toolbox.", 
			"I don't get paid enough for this.", "How am I going to fix this...", "Is it time to go home yet?", "Easy fix!",  
			"I got grease on my new pants!", "I deserve a raise.", "Another easy fix!" };
	
	/**
	 * Constructor.
	 * @param id The ID of the menu.
	 */
	public EmployeeMenu(String id) {
		super(id);
	}
	
	@Override
	public void display() throws InterruptedException {
		clear();
		
		// Employee is can choose to check the machines or log out
		printBanner("Employee Portal - Main Menu");
		userPrint("Terminal", "Please select an option below.");
		
		System.out.println("1. Check Machines.");
		System.out.println("2. Log out of Employee Terminal.");
		
		//Takes user input
		int choice = InputManager.getIntegerFromUser(3);
		
		//Based on the employees choice, It will allow them to check the machines or log out of the menu
		switch(choice) {
		case 1:
			fixMenu();
			break;
		case 2:
			logOut();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Displays the fix menu.
	 * @throws InterruptedException
	 */
	//Checking status of machines and fixing them
	public void fixMenu() throws InterruptedException {
		clear();
		printBanner("Employee Portal - Machine Status Menu");
		userPrint("Employee Terminal", "Checking Status of the Slot Machines.");
		
		sleep(3000);
		
		//Creates a file that stores all of the broken machines 
		File file = new File("reports.txt");
		int num = 0;
		try {
			Scanner scanner = new Scanner(file);
			
			// Display the machines that need fixing.
			while(scanner.hasNextLine()) {
				num ++;
				String machine = scanner.nextLine();
				System.out.println(String.format("%s. %s", num, machine));
				machinesToFix.add(machine);
			}
			System.out.println(String.format("%s. Exit", num + 1));
			scanner.close();
			
			// Prints if nothing needs to be fixed
		} catch (FileNotFoundException e) {
			userPrint("Terminal", "Nothing needs fixing!");
		}
	
		sleep(3000);
		fixSlot(num);
	}
	
	/**
	 * Log out and return to main.
	 * @throws InterruptedException
	 */
	//Logging out of employee terminal 
	public void logOut() throws InterruptedException {
		clear();
		printBanner("Employee Portal - Logging Out");
		userPrint("Employee Terminal", "Logging out. Please wait...");
		
		sleep(3000);
		
		userPrint("Employee Terminal", "Log out successful, Thank you.");
		
		sleep(1500);
		
		goTo("Main");
	}
	

	/**
	 * Fixes a slot machine and removes it from the list.
	 * @param num The number of machines.
	 * @throws InterruptedException
	 */
	//Asks the employee what machine they want to fix and asks for their input
	private void fixSlot(int num) throws InterruptedException {
		userPrint("Terminal", "Which machine would you like to fix?");
		int choice = InputManager.getIntegerFromUser(num + 1);
		
		// Exit.
		if(choice == num + 1) {
			logOut();
		}
		
		//Sends employee to broken machine
		userPrint("Terminal", String.format("You got it! Sending over %s.", machinesToFix.get(choice - 1).substring(0, 16)));
		sleep(3000);
		
		clear();
		
		//Machine fix flavor text
		printBanner("Casino - Repair Room");
		System.out.println("You walk over to the Repair Room and see the machine.");
		sleep(1500);
		System.out.println("You begin to work on the issues...");
		sleep(3000);
		
		// Remove from the list
		machinesToFix.remove(choice - 1);
		
		for(int i = 0; i < 6; i ++) {
			clear();
			printBanner("Casino - Repair Room");
			
			//Prints out a random response from the employee when fixing the machine
			int index = new Random().nextInt(fixPrompts.length);
			
			System.out.println(fixPrompts[index]);
			sleep(2500 * (1 + new Random().nextInt(3)));
		}
		
		try {
			// Replace the old reports file with a blank text file
			FileWriter writer = new FileWriter("reports.txt", false);
			writer.write("");
			
			// Rewrite new data to it
			FileWriter writer2 = new FileWriter("reports.txt", true);
			
			for(String s : machinesToFix) {
				writer2.write(s + "\n");
			}
			
			// Close file writers
			writer.close();
			writer2.close();
			
		} catch (IOException e) {
			System.out.println("Error: reports.txt not found, was it deleted?");
		}
		System.out.println("Machine fixed!");
		sleep(3000);
		goTo("EMenu");
	}		
}
