/**
 * Program to Person
 * Author : Kang Hong Gu 
 * Programming Project4 in chapter5
 * Last Changed : April. 10. 2014
 */
public class Person {
	private String name;
	private int age;

	//set name
	public void setName(String name) {
		this.name = name;
	}
	//set age
	public void setAge(int age) {
		this.age = age;
	}

	//check object 1 and 2 same person
	public boolean samePerson(Person otherPerson) {
		if (this.name.equalsIgnoreCase(otherPerson.name)
				&& this.age == otherPerson.age) {
			return true;
		} else
			return false;
	}
	//check object 1 and 2 same name
	public boolean sameName(Person otherPerson) {
		if (this.name.equalsIgnoreCase(otherPerson.name)) {
			return true;
		} else
			return false;
	}
	//check object 1 and 2 same age
	public boolean sameAge(Person otherPerson) {
		if (this.age == otherPerson.age) {
			return true;
		} else
			return false;
	}
	//check older or younger person
	public void compareAge(Person otherPerson) {
		if (this.age > otherPerson.age) {
			System.out.print(this.name + "is older than " + otherPerson.name);
		} else if (this.age < otherPerson.age) {
			System.out.print(this.name + "is younger than " + otherPerson.name);
		} else {
			System.out.print("Same age");
		}
	}

}