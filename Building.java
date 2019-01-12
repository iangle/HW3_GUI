/**@author Isaac Angle
 * This class is the base class for all buildings 
 * in the city. They have a name and an address*/
package HW2.edu.whitworth.spokane;

public abstract class Building {
	String name,address;
	/**@param takes a name and an address for the building that 
	 * is being created*/
	Building(String name, String address){
		this.name =  name;
		this.address = address;
	}
	
}