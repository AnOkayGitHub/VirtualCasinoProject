
public class ExitMenu extends Menu {

	protected ExitMenu(String id) {
		super(id);
	}
	
	@Override
	public void display() {
		clear();
		printBanner("Casino - Exit");
		userPrint("Front Desk Assistant", "Thank you for coming. Have a nice day!");
	}
	
}
