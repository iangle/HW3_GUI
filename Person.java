/**@author Isaac Angle
 * This class is the abstract class that all
 * citizens of Spokane will draw from*/
package HW2.edu.whitworth.spokane;

public abstract class Person {
	
	private String name = "Isaac";
	private String phoneNumber = "509-860-5309";
	private int age = 20;
	
	/**@return returns the name of the citizen*/
	public String getName() {
		return name;
	}

	/**@param takes a name and replaces the citizens name with its*/
	public void setName(String name) {
		this.name = name;
	}

	/**@return returns the phoneNumber of the citizen*/
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**@param takes a number from the user and then replaces the citizens number with it*/
	public void setPhoneNumber(String phoneNumber) {
		boolean matches = phoneNumber.matches("\\d\\d\\d\\-\\d\\d\\d\\-\\d\\d\\d\\d");
		if(matches) {
			this.phoneNumber = phoneNumber;
		}else{
			System.out.println("That is not a valid phone number! ");
		}
	}

	/**@return returns the age of the citizen*/
	public int getAge() {
		return age;
	}

	/**@param takes an age and replaces the citizens age with that age*/
	public void setAge(int age) {
		if(age < 120 && age > 0) {
			this.age = age;
		}else{
			System.out.println("That is not a valid age! ");
		}
	}

	/**@param takes the name, number, and age of a person -- this is the default constructor*/
	Person(String name, String number, int age){
		this.name = name;
		this.phoneNumber = number;
		this.age = age;
	}
}
