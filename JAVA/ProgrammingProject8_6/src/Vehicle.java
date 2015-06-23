/**
 * Author : Kang Hong Gu 
 * Programming Project6 in chapter8
 */
public class Vehicle {
	private String nameOfManufactures;
	private int numberOfCylinders;
	private Person owner;

	public Vehicle(String name, int num, Person owner) {
		this.nameOfManufactures = name;
		this.numberOfCylinders = num;
		this.owner = owner;
	}

	public String getName() {
		return this.nameOfManufactures;
	}

	public int getNumberOfCylinder() {
		return this.numberOfCylinders;
	}

	public boolean equal(Vehicle other) {
		if (this.nameOfManufactures.equalsIgnoreCase(other.nameOfManufactures)
				&& (this.numberOfCylinders == other.numberOfCylinders)
				&& (this.owner.hasSameName(other.owner))) {
			return true;
		} else {
			return false;
		}

	}

}
