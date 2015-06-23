/**
 * Program to DistributeGradeDemo
 * Author : Kang Hong Gu 
 * Programming Project5 in chapter5
 * Last Changed : April. 10. 2014
 */
public class DistributeGradeDemo {
	public static void main(String[] args)
	{
		DistributeGrade test = new DistributeGrade();
		//Create objcet
		test.inputStudent();
		//call input method
		
		System.out.println("All student : " + test.getAllStudnt());
		System.out.println("GRADE A (%) : " + test.getStdPercentageA());
		System.out.println("GRADE B (%) : " + test.getStdPercentageB());
		System.out.println("GRADE C (%) : " + test.getStdPercentageC());
		System.out.println("GRADE D (%) : " + test.getStdPercentageD());
		System.out.println("GRADE F (%) : " + test.getStdPercentageF());
		System.out.println("Representing the graph of student grade");
		test.drawGraph();
		//print all result
	}
}
