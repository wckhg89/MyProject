import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Program to ReadFile
 * Author : Kang Hong Gu 
 * Programming Project1 in chapter10
 */

public class ReadFile {
	String fileName;
	File number;
	Scanner inputStream = null;
	
	public ReadFile(String fileName)
	{
		this.fileName = fileName;
		this.number = new File(this.fileName); 
	}
	/*
	 * this function read file
	 */
	public void readFile()
	{
		try {
			inputStream  = new Scanner(number);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found Exception occuer!");
			e.printStackTrace();
			System.exit(0);
		}
		this.caculateValue();
	}
	/*
	 * this functin calculate average , maximum number and minimum number.
	 */
	private void caculateValue()
	{
		int count=0;
		double min = 0;
		double max = 0;
		double sum=0;
		double tmp=0;
		
		while(inputStream.hasNextLine())
		{
			sum+= Double.parseDouble(inputStream.nextLine());
			tmp = Double.parseDouble(inputStream.nextLine());
			if(count==0)
			{
				min=Double.parseDouble(inputStream.nextLine());
				max=Double.parseDouble(inputStream.nextLine());
			}
			else{
				if(min > tmp){
					min = tmp;
				}
				if(max < tmp)
				{
					max = tmp;
				}
			}
			count++;
		}
		inputStream.close();
		System.out.println("Average value of 'number.txt' is " + sum/count);
		System.out.println("Maximum value of 'number.txt' is " + max);
		System.out.println("Minimum value of 'number.txt' is " + min);
		
	}
	
}
