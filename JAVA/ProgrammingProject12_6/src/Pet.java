/**
 * Programming projcet 12_6
 * 200932220 °­È«±¸
 * @author honggu
 *
 */
public class Pet {
	private String name;
	private int age;
	private double weight;
	
	/**
	 * constructor
	 * @param name
	 * @param age
	 * @param weight
	 */
	public Pet(String name, int age, double weight)
	{
		this.name= name;
		if((age<0) || (weight <0))
		{
			System.out.println("Error : Negative age or weight.");
			System.exit(0);
		}
		else{
			this.age = age;
			this.weight = weight;
		}
	}
	
	/**
	 * setter
	 * @param name
	 * @param age
	 * @param weight
	 */
	public void setPet(String name, int age, double weight)
	{
		this.name= name;
		if((age<0) || (weight <0))
		{
			System.out.println("Error : Negative age or weight.");
			System.exit(0);
		}
		else{
			this.age = age;
			this.weight = weight;
		}
	}
	/**
	 * getter
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public double getWeight()
	{
		return weight;
	}
}
