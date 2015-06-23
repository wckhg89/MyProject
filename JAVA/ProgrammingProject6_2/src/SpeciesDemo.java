/**
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter6
 * Last Changed : April. 28. 2014
 */

public class SpeciesDemo {
	public static void main(String[] args)
	{
		Species test = new Species("honggu", 100, 10);
		test.writeOutput();
		System.out.println("10 years late population :  " + test.predictPopulation(10));
	}
}
