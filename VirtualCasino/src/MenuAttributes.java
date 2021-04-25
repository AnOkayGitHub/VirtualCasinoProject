import java.io.IOException;

/**
 * Interface For Menus.
 */

/**
 * @author Nick, Ryan
 *
 */
public interface MenuAttributes {
	/**
	 * Moves to the new target menu.
	 * @param target The target menu ID to move to.
	 */
	public void goTo(String target);
	
	/**
	 * Displays the contents of the menu.
	 * @throws InterruptedException Used for the sleep functionality.
	 */
	public void display() throws InterruptedException;
	
	/**
	 * Returns the ID of the object called from.
	 * @return String ID.
	 */
	public String getID();
}
