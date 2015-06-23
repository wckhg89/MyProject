import java.util.ArrayList;
import java.util.Scanner;
/**
 * Programming projcet 12_5
 * 200932220 °­È«±¸
 * @author honggu
 *
 */
public class ArrayListOfPet2 {
	ArrayList<Pet> pets;

	/**
	 * constructor.
	 */
	public ArrayListOfPet2() {
		pets = new ArrayList<Pet>();
	}

	/**
	 * get object by user input
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

			Pet tempPet = new Pet(name, age, weight);
			pets.add(i, tempPet);
		}
		System.out.println("Create Pet object success !");
	}

	/**
	 * print all list of pet non ordering
	 */
	public void printAllPet() {
		System.out.println("<<All list of your pet>>");
		for (int i = 0; i < pets.size(); i++) {
			System.out
					.println("----------------------------------------------------");
			System.out.println("No." + (i + 1) + "'s pet's name is "
					+ pets.get(i).getName());
			System.out.println("No." + (i + 1) + "'s pet's age is "
					+ pets.get(i).getAge());
			System.out.println("No." + (i + 1) + "'s pet's weight is "
					+ pets.get(i).getWeight());

		}
	}

	/**
	 * print all lsit of pet ordered by weight
	 */
	public void printOrderedAllPet() {
		orderedByPetName();
		System.out.println("<<All list of your pet orderd by pet's name>>");
		for (int i = 0; i < pets.size(); i++) {
			System.out
					.println("----------------------------------------------------");
			System.out.println("No." + (i + 1) + "'s pet's name is "
					+ pets.get(i).getName());
			System.out.println("No." + (i + 1) + "'s pet's age is "
					+ pets.get(i).getAge());
			System.out.println("No." + (i + 1) + "'s pet's weight is "
					+ pets.get(i).getWeight());

		}
	}

	/**
	 * all pet list oderd by pet's weight
	 */
	private void orderedByPetName() {
		for (int i = 0; i < pets.size(); i++) {
			for (int j = 0; j < pets.size() - 1; j++) {
				if (pets.get(j).getWeight()>pets.get(j + 1).getWeight()) {
					Pet pet = pets.get(j);
					pets.set(j, pets.get(j + 1));
					pets.set(j + 1, pet);
				}
			}
		}
	}
	/**
	 * obtain percentage of pet
	 */
	public void percentageOfPet()
	{
		int allPet = pets.size();
		int under5Pets = 0;
		int between5to10pets = 0;
		int over10Pets = 0;
		for(int i=0 ; i<pets.size() ; i++)
		{
			if(pets.get(i).getWeight() < 5){
				under5Pets++;
			}
			else if(pets.get(i).getWeight() >= 5 && pets.get(i).getWeight() <=10){
				between5to10pets++;
			}else if(pets.get(i).getWeight() > 10){
				over10Pets++;
			}
		}
		System.out
		.println("----------------------------------------------------");
		System.out.println("Under 5pounds pet % : "+ (double)under5Pets/ allPet);
		System.out.println("Betwwen 5 and 10 pounds pet % : "+ (double)under5Pets/ allPet);
		System.out.println("Over 10pounds pet % : "+ (double)under5Pets/ allPet);
	}
	public static void main(String[] args) {
		ArrayListOfPet2 test = new ArrayListOfPet2();
		test.getPetObject();
		test.printAllPet();
		test.printOrderedAllPet();
		test.percentageOfPet();
	}

}
