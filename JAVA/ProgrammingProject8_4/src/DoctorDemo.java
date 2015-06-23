/**
 * Author : Kang Hong Gu 
 * Programming Project4 in chapter8
 */
public class DoctorDemo {
	public static void main(String[] args)
	{
		Doctor test = new Doctor("Honggu", 100);
		System.out.println("Doctor name is " + test.getName());
		System.out.println("Doctor's visit fee are " + test.getVisitFee());
		
		Doctor test2 = new Doctor("Minjun" , 200);
		
		if(test.equals(test2))
			System.out.println("This doctor's same doctor");
		else
			System.out.println("This doctor's other doctor");
	}
}
