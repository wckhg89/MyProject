/**
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter6
 * Last Changed : April. 28. 2014
 */

import java.util.Scanner;
public class Species {
	private String name;
	private int population;
	private double growthRate;
	
	//default constructor
	public Species()
	{
		
	}
	//constructor1
	public Species(String name)
	{
		this.name = name;
	}
	//constructor2
	public Species(int population)
	{
		this.population = population;
	}
	//constructor3
	public Species(double growthRate)
	{
		this.growthRate = growthRate;
	}
	//constructor4
	public Species(String name, int population, double growthRate)
	{
		this.name = name;
		this.population = population;
		this.growthRate = growthRate;
	}
	
	//mutator with 3 parameter
	public void setSpecies(String newName, int newPopulation, double newGrowthRate)
	{
		name = newName;
		if(newPopulation >=0)
		{
			population = newPopulation;
		}
		else
		{
			System.exit(0);
		}
		growthRate = newGrowthRate;
	}
	//mutator with 1 parameter
	public void setName(String name)
	{
		this.name = name;
	}
	//mutator with 1 parameter
	public void setPopulation(int population)
	{
		this.population = population;
	}
	//mutator with 1 parameter
	public void setGrowthRate(double growthRate)
	{
		this.growthRate = growthRate;
	}
	
	public String getName()
	{
		return name;
	}
	public int getPopulatin()
	{
		return population;
	}
	public double getGrowthRate()
	{
		return growthRate;
	}
	
	public void readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the species' name ? ");
		name = keyboard.nextLine();
		System.out.println("What is the population of the species ? ");
		population = keyboard.nextInt();
		System.out.println("Enter growth rate (% increase per year) : ");
		growthRate = keyboard.nextDouble();
	}
	public void writeOutput()
	{
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Growth rate = " + growthRate + "%");
	}
	public int predictPopulation(int year)
	{
		int result = 0;
		double populationAmount = population;
		int count = year;
		while((count > 0) && (populationAmount > 0))
		{
			populationAmount = (populationAmount + (growthRate/100) * populationAmount);
			count--;
		}
		if(populationAmount > 0)
		{
			result = (int)populationAmount;
		}
		return result;
	}
	
}
