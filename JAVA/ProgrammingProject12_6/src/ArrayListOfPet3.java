import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Programming projcet 12_6
 * 200932220 °­È«±¸
 * @author honggu
 *
 */
public class ArrayListOfPet3 {
	ArrayList<Pet> pets;
	File file;

	/**
	 * constructor.
	 */
	public ArrayListOfPet3() {
		pets = new ArrayList<Pet>();
	}

	/**
	 * create object pet using file IO
	 */
	public void getPetObject() {
		String fileName;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the file name : ");
		fileName = keyboard.next();

		file = new File(fileName);

		Scanner inputStream = null;

		try {
			inputStream = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error : File not found!!");
			System.exit(0);
		}

		while (inputStream.hasNextLine()) {
			int i = 0;
			String line = inputStream.nextLine();
			String[] tmp = line.split(" ");
			Pet pet = new Pet(tmp[0], Integer.parseInt(tmp[1]),
					Double.parseDouble(tmp[2]));
			pets.add(i, pet);
			i++;
		}
		System.out.println("Create Pet object success !");
	}

	/**
	 * print all list of pet non order
	 */
	public void printAllPet() {
		
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new File("allListPets.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		outputStream.println("<<All list of your pet>>");
		for (int i = 0; i < pets.size(); i++) {
			outputStream
					.println("----------------------------------------------------");
			outputStream.println("No." + (i + 1) + "'s pet's name is "
					+ pets.get(i).getName());
			outputStream.println("No." + (i + 1) + "'s pet's age is "
					+ pets.get(i).getAge());
			outputStream.println("No." + (i + 1) + "'s pet's weight is "
					+ pets.get(i).getWeight());

		}
		outputStream.close();
		System.out.println("Success write file !");
	}

	/**
	 * print all list of pet ordered by weight
	 */
	public void printOrderedAllPet() {
		orderedByPetName();
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new File("allListPetsOrdered.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		outputStream.println("<<All list of your pet>>");
		for (int i = 0; i < pets.size(); i++) {
			outputStream
					.println("----------------------------------------------------");
			outputStream.println("No." + (i + 1) + "'s pet's name is "
					+ pets.get(i).getName());
			outputStream.println("No." + (i + 1) + "'s pet's age is "
					+ pets.get(i).getAge());
			outputStream.println("No." + (i + 1) + "'s pet's weight is "
					+ pets.get(i).getWeight());

		}
		outputStream.close();
		System.out.println("Success write file !");
	}

	private void orderedByPetName() {
		for (int i = 0; i < pets.size(); i++) {
			for (int j = 0; j < pets.size() - 1; j++) {
				if (pets.get(j).getWeight() > pets.get(j + 1).getWeight()) {
					Pet pet = pets.get(j);
					pets.set(j, pets.get(j + 1));
					pets.set(j + 1, pet);
				}
			}
		}
	}

	public void percentageOfPet() {
		int allPet = pets.size();
		int under5Pets = 0;
		int between5to10pets = 0;
		int over10Pets = 0;
		
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new File("percentageOfPets.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getWeight() < 5) {
				under5Pets++;
			} else if (pets.get(i).getWeight() >= 5
					&& pets.get(i).getWeight() <= 10) {
				between5to10pets++;
			} else if (pets.get(i).getWeight() > 10) {
				over10Pets++;
			}
		}
		outputStream
				.println("----------------------------------------------------");
		outputStream.println("Under 5pounds pet % : " + (double) under5Pets
				/ allPet);
		outputStream.println("Betwwen 5 and 10 pounds pet % : "
				+ (double) under5Pets / allPet);
		outputStream.println("Over 10pounds pet % : " + (double) under5Pets
				/ allPet);
		outputStream.close();
		System.out.println("Success write file !");
	}

	public static void main(String[] args) {
		ArrayListOfPet3 test = new ArrayListOfPet3();
		test.getPetObject();
		test.printAllPet();
		test.printOrderedAllPet();
		test.percentageOfPet();
	}

}
