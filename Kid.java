/**@author Isaac Angle
 * This class is the kid class which has a string that
 * holds the kid's favorite candy. It inherits from Person*/
package HW2.edu.whitworth.spokane;

public class Kid extends Person{
	
	private String favCandy;
	
	/**@param takes the name, number, age and favorite candy of the kid*/
	Kid(String name, String number, int age,String favCandy) {
		super(name, number, age);
		this.favCandy = favCandy;
	}
	/**@return returns the child's favorite candy*/
	public String getFavCandy() {
		return favCandy;
	}

}
