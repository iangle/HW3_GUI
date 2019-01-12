/**@author Isaac Angle
 * This class holds the police officer who has different roles
 * and inherits from the base class Person*/
package HW2.edu.whitworth.spokane;
import java.util.Scanner;
public class Police extends Person implements Employee{
	// the role of the police officer
	private Scanner scan;
	private int moneyAmount;
	private Role role;
	
	/**@param takes the name, the phone number, the age, and the role of the
	 * police officer*/
	Police(String name, String number, int age,Role role, int moneyAmount) {
		super(name, number, age);
		this.moneyAmount = moneyAmount;
		this.role = role;
	}
	/**@param takes in an amount and add it to the current amount*/
	@Override
	public void payEmployee(int amount) {
		moneyAmount += amount;
		
	}
	/**@return asks the user for their ID and then returns it*/
	@Override
	public String askID() {
		System.out.println("What is your ID? ");
		String userID = scan.nextLine();
		return userID;
		
	}
	/**@return returns the amount of money that the employee has*/
	@Override
	public int getMoneyAmount() {
		return moneyAmount;
	}
	
	public Role getRole() {
		return role;
	}
	

}
