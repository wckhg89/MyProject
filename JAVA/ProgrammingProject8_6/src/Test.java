/**
 * Author : Kang Hong Gu 
 * Programming Project6 in chapter8
 */
public class Test {
	public static void main(String[] args)
	{
		Truck test = new Truck("hong", 100 , new Person("honggu"), 10 ,20);
		Truck test2 = new Truck("hong2", 200 , new Person("honggu2"), 20 ,30);
		
		System.out.println(test.getName());
		System.out.println(test.getNumberOfCylinder());
		System.out.println(test.getLoadCape());
		System.out.println(test.getTowingCap());
		
		if(test.equal(test2))
		{
			System.out.println("same");
		}
		else
		{
			System.out.println("different");
		}
	}
}
