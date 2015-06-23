/**
 * Program to PersonDemo
 * Author : Kang Hong Gu 
 * Programming Project4 in chapter5
 * Last Changed : April. 10. 2014
 */
public class PersonDemo {
	public static void main(String[] args)
	{
		Person test = new Person();
		Person test2 = new Person();
		//create object two.
		test.setName("∞≠»´±∏");
		test.setAge(26);
		test2.setName("√÷πŒ¡ÿ");
		test2.setAge(25);
		//set name and age
		
		//Check same person
		if(test.samePerson(test2)==true)
		{
			System.out.println("Same person.");
		}
		else{
			System.out.println("Non same person.");
		}
		
		//Check same name.
		if(test.sameName(test2)==true)
		{
			System.out.println("Same name.");
		}
		else{
			System.out.println("Non same name.");
		}
		
		//Check same age
		if(test.sameAge(test2)==true)
		{
			System.out.println("Same age.");
		}
		else{
			System.out.println("Non same age.");
		}
		
		//compare age
		test.compareAge(test2);
	}
}
