import java.util.ArrayList;
import java.util.Scanner;
/**
 * Programming projcet 12_4
 * 200932220 °­È«±¸
 * @author honggu
 *
 */
public class ArrayListOfPet {
	ArrayList<Pet> pets;

	/**
	 * consturctor
	 */
	public ArrayListOfPet() {
		pets = new ArrayList<Pet>();
	}
	/**
	 * get object by user inpus
	 */
	public void getPetObject() {
		int num;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number of Pet object created by user : ");
		num = keyboard.nextInt();

		for (int i = 0; i < num; i++) {
			String name;
			int age;
			double weight;
			System.out.print("Entert the Pet No." + (i + 1) + "'s Name : ");
			name = keyboard.next();
			System.out.print(name);
			System.out.print("Entert the Pet No." + (i + 1) + "'s Age : ");
			age = keyboard.nextInt();
			System.out.print("Entert the Pet No." + (i + 1) + "'s Weight : ");
			weight = keyboard.nextDouble();
			
			Pet tempPet = new Pet(name,age,weight);
			pets.add(i,tempPet);
		}
		System.out.println("Create Pet object success !");
	}
	
	/**
	 * print all pet non ordering
	 */
	public void printAllPet()
	{
		System.out.println("<<All list of your pet>>");
		for(int i=0 ; i<pets.size() ; i++)
		{
			System.out.println("----------------------------------------------------");
			System.out.println("No."+(i+1)+"'s pet's name is " + pets.get(i).getName());
			System.out.println("No."+(i+1)+"'s pet's age is " + pets.get(i).getAge());
			System.out.println("No."+(i+1)+"'s pet's weight is " + pets.get(i).getWeight());
				
		}
	}
	/**
	 * print all pet list ordered by name
	 */
	public void printOrderedAllPet()
	{
		orderedByPetName();
		System.out.println("<<All list of your pet orderd by pet's name>>");
		for(int i=0 ; i<pets.size() ; i++)
		{
			System.out.println("----------------------------------------------------");
			System.out.println("No."+(i+1)+"'s pet's name is " + pets.get(i).getName());
			System.out.println("No."+(i+1)+"'s pet's age is " + pets.get(i).getAge());
			System.out.println("No."+(i+1)+"'s pet's weight is " + pets.get(i).getWeight());
				
		}
	}
	/**
	 * ordering pet by name
	 */
	private void orderedByPetName()
	{
		for(int i=0 ; i<pets.size() ; i++)
		{
			for(int j=0 ; j<pets.size()-1 ; j++)
			{
				if(pets.get(j).getName().compareTo(pets.get(j+1).getName()) >0 ){
					Pet pet = pets.get(j);
					pets.set(j, pets.get(j+1));
					pets.set(j+1, pet);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		ArrayListOfPet test = new ArrayListOfPet();
		test.getPetObject();
		test.printAllPet();
		test.printOrderedAllPet();
	}
	
}
