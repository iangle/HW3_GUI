/**@author Isaac Angle
 * This interface is emplomented by the teacher and 
 * police class and has a way to pay employees
 * and a way to get their money and their ID*/
package HW2.edu.whitworth.spokane;

public interface Employee {
	
	/**@param takes a money amount and adds it to the total
	 * money of the employee*/
	void payEmployee(int amount);
	
	/**@return returns a string that gets the users ID*/
	String askID();
	
	/**@return returns the amount of money that the employee has*/
	int getMoneyAmount();
}
