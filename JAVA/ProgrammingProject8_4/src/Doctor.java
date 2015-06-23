/**
 * Author : Kang Hong Gu 
 * Programming Project11 in chapter8
 */
public class Doctor extends Person{
	
	private double visitFee;
	
	/*
	 * Constructor
	 */
	public Doctor(String newName, double newVisitFee)
	{
		super(newName);
		this.visitFee = newVisitFee;
	}
	
	
	/*
	 * Accessor mehod.
	 */
	public double getVisitFee()
	{
		return visitFee;
	}
	
	/*
	 * Equal method
	 */
	public boolean equals(Doctor otherDoctor)
	{
		boolean equal = false;
		if(super.hasSameName(otherDoctor) && this.visitFee == otherDoctor.visitFee)
		{
			equal = true;
		}
		else{
			equal = false;
		}
		return equal;
		
	}
	
}
