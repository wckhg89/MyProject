/**
 * Author : Kang Hong Gu 
 * Programming Project6 in chapter8
 */
public class Person {
	private String name;
	
	public Person()
	{
		this.name = "No name yet";
	}
	public Person(String initialName)
	{
		this.name  = initialName;
	}
	public void setName(String newName)
	{
		this.name = newName;
	}
	public String getName()
	{
		return name;
	}
	public void writeOutput()
	{
		System.out.println("Name: " + name);
	}
	public boolean hasSameName(Person otherPerson)
	{
		return this.name.equalsIgnoreCase(otherPerson.name);
	}
}
