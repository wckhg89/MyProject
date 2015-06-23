/**
 * Author : Kang Hong Gu 
 * Programming Project6 in chapter8
 */
public class Truck extends Vehicle {

	private double loadCap;
	private double towingCap;

	public Truck(String name, int num, Person owner, double loadCap,
			double towingCap) {
		super(name, num, owner);
		this.loadCap = loadCap;
		this.towingCap = towingCap;
		// TODO Auto-generated constructor stub
	}

	public double getLoadCape() {
		return loadCap;
	}

	public double getTowingCap() {
		return towingCap;
	}

	public boolean equal(Truck other) {
		if (super.equal(other) && this.loadCap == other.loadCap
				&& this.towingCap == other.towingCap) {
			return true;
		} else
			return false;
	}

}
