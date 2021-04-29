
public class ExitMenu extends Menu {

	protected ExitMenu(String id) {
		super(id);
	}
	
	@Override
	//Exiting the casino from the main menu / front desk
	public void display() {
		clear();
		printBanner("Casino - Exit");
		userPrint("Front Desk Assistant", "Thank you for coming. Have a nice day!");
	}
	
}
