
/**
 * Interface For Menus.
 */

/**
 * @author Nick, Matt, Ryan, Brandon
 *
 */
public interface MenuAttributes {
	/**
	 * Moves to the new target menu.
	 * @param target The target menu ID to move to.
	 */
	public void goTo(String target) throws InterruptedException;
	
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
	
	/**
	 * 
	 * @param waitTime In milliseconds
	 * @throws InterruptedException  Used for the sleep functionality.
	 */
	public void sleep(int waitTime) throws InterruptedException;
}
