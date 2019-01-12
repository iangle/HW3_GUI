/**@author Isaac Angle
 * This class is the teacher class which has a grade level and 
 * a certification, it inherits from the Person class*/
package HW2.edu.whitworth.spokane;
import java.util.Scanner;
public class Teacher extends Person implements Employee{
	private Scanner scan;
	private int gradeLevel;
	private String certification;
	private int moneyAmount;
	
	/**@return returns the teachers grade level*/
	public int getGradeLevel() {
		return gradeLevel;
	}
	
	/**@return returns the teachers certification*/
	public String getCertification() {
		return certification;
	}
	
	/**@param takes the name, the phone number, the age, the grade level and the certification
	 * of the teacher*/
	Teacher(String name, String number, int age, int gradeLevel, String certification, int moneyAmount) {
		super(name, number, age);
		this.gradeLevel = gradeLevel;
		this.certification = certification;
		this.moneyAmount = moneyAmount;
	}
	
	/**@param takes in an amount and add it to the current amount*/
	@Override
	public void payEmployee(int amount) {
		moneyAmount += amount;
		
	}
	
	/**@return asks the user for their ID and then returns it*/
	@Override
	public String askID() {
		System.out.println("What is your employee ID? ");
		String UserID = scan.nextLine();
		return UserID;
	}
	
	/**@return returns the amount of money that the employee has*/
	@Override
	public int getMoneyAmount() {
		return moneyAmount;
	}

}
