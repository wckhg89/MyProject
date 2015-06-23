import java.util.Scanner;
/**
 * Program to DistributeGrade
 * Author : Kang Hong Gu 
 * Programming Project5 in chapter5
 * Last Changed : April. 10. 2014
 */
public class DistributeGrade {
	private int all;
	private int gradeA;
	private int gradeB;
	private int gradeC;
	private int gradeD;
	private int gradeF;

	//setter
	public void setStudent(int stdA, int stdB, int stdC, int stdD, int stdF) {
		this.gradeA = stdA;
		this.gradeB = stdB;
		this.gradeC = stdC;
		this.gradeD = stdD;
		this.gradeF = stdF;
		this.all  = gradeA + gradeB + gradeC + gradeD + gradeF;
	}

	//input method
	public void inputStudent() {
		int tmpA, tmpB, tmpC, tmpD, tmpF;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the grade A : ");
		tmpA = keyboard.nextInt();
		System.out.print("Enter the grade B : ");
		tmpB = keyboard.nextInt();
		System.out.print("Enter the grade C : ");
		tmpC = keyboard.nextInt();
		System.out.print("Enter the grade D : ");
		tmpD = keyboard.nextInt();
		System.out.print("Enter the grade F : ");
		tmpF = keyboard.nextInt();

		this.setStudent(tmpA, tmpB, tmpC, tmpD, tmpF);
	}

	//getter
	public int getAllStudnt() {
		
		return all;
	}

	//get percentage.
	public double getStdPercentageA() {
		double perA;
		perA = (double)gradeA / all * 100;

		return perA;
	}
	//get percentage.
	public double getStdPercentageB() {
		double perB;
		perB = (double)gradeB / all * 100;

		return perB;
	}
	//get percentage.
	public double getStdPercentageC() {
		double perC;
		perC = (double)gradeC / all * 100;

		return perC;
	}

	public double getStdPercentageD() {
		double perD;
		perD = (double)gradeD / all * 100;

		return perD;
	}
	//get percentage.
	public double getStdPercentageF() {
		double perF;
		perF = (double)gradeF / all * 100;

		return perF;
	}
	//draw graph
	public void drawGraph() {
		int tmp = 0;
		System.out
				.println("0  10   20   30   40   50   60   70   80   90   100");
		System.out
				.println("**************************************************");
		
		for (int j = 0; j < 5; j++) {
			switch(j)
			{
			case 0:
				tmp = (int) ((this.getStdPercentageA()/100 * 50) + 0.5);
				break;
			case 1:
				tmp = (int) ((this.getStdPercentageB()/100 * 50) + 0.5);
				break;
			case 2:
				tmp = (int) ((this.getStdPercentageC()/100 * 50) + 0.5);
				break;
			case 3:
				tmp = (int) ((this.getStdPercentageD()/100* 50) + 0.5);
				break;
			case 4:
				tmp = (int) ((this.getStdPercentageF()/100 * 50) + 0.5);
				break;
			}
			for (int i = 0; i < tmp ; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
