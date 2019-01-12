/**@author Isaac Angle
 * This class inherits from the Building base class
 * and implements an array of occupants*/
package HW2.edu.whitworth.spokane;

public class CityHall extends Building {
	private Police occupants[];
	
	/**@param takes the name, address and the occupants of City Hall*/
	CityHall(String name, String address, Police occupants[]) {
		super(name, address);
		this.occupants = occupants;
	}
	/**@return returns the occupants of CityHall*/
	public Police[] getOccupants() {
		return occupants;
	}

}
