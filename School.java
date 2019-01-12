/**@author Isaac Angle
 * This class inherits from the Building base class
 * and implements an array of occupants*/
package HW2.edu.whitworth.spokane;

public class School extends Building{
	private Teacher occupants[];
	private Kid students[];
	/**@param takes the name and address of the school. Also takes the teachers and the students that reside in the school*/
	School(String name, String address, Teacher occupants[], Kid[] students) {
		super(name, address);
		this.occupants = occupants;
		this.students = students;
	}
	/**@return returns an array of teachers*/
	public Teacher[] getTeachers() {
		return occupants;
	}
	/**@return returns an array of students*/
	public Kid[] getStudents() {
		return students;
	}
	

}
