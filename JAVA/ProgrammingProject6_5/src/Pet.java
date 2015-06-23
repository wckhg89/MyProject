/**
 * Author : Kang Hong Gu 
 * Programming Project5 in chapter6
 * Last Changed : April. 28. 2014
 */

public class Pet {
	private String name;
	private int age;
	private double weight;

	//constructor
	public Pet(String newName, int newAge, double newWeight) {
		this.setPet(newName, newAge, newWeight);
	}

	//mutator
	public void setPet(String name, int age, double weight) {
		this.name = name;
		if ((age < 0) || (weight < 0)) {
			System.exit(0);
		}
		else
		{
			this.age = age;
			this.weight = weight;
		}
	}
	
	//getter
	public String getName()
	{
		return name;
	}
	//getter
	public int getAge()
	{
		return age;
	}
	public double getWeight()
	{
		return weight;
	}
	
	//data
	public void petData(Pet[] tst)
	{
		
		Pet maxWeight = tst[0];
		Pet minWeight = tst[0];
		
		Pet maxAge = tst[0];
		Pet minAge = tst[0];
		
		for(int i = 1 ; i<5 ; i++)
		{
			if(maxWeight.weight < tst[i].weight)
			{
				maxWeight = tst[i];
			}
			if(minWeight.weight > tst[i].weight)
			{
				minWeight = tst[i];
			}
			if(maxAge.age < tst[i].age)
			{
				maxAge = tst[i];
			}
			if(minAge.age > tst[i].age)
			{
				minAge = tst[i];
			}
		}
		
		double aveWeight = 0;
		int aveAge = 0;
		for(int i = 0 ;i<5 ; i++)
		{
			aveWeight += tst[i].weight;
			aveAge += tst[i].age;
		}
		
		//print result
		System.out.println("Average weight : " + aveWeight/5);
		System.out.println("Average age : " + aveAge/5);
		System.out.println("Max weight pet name : " + maxWeight.name);
		System.out.println("Min weight pet name : " + minWeight.name);
		System.out.println("Min Age pet name : " + maxAge.name);
		System.out.println("Min Age pet name : " + maxAge.name);
	}
	

}
