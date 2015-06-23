import java.util.Scanner;
/**
 * Program to StudentGrade
 * Author : Kang Hong Gu 
 * Programming Project3 in chapter5
 * Last Changed : April. 10. 2014
 */
public class StudentGrade {
	private double quiz1Score;
	private double quiz2Score;
	private double midtermScore;
	private double finalScore;
	private double totalScore;
	private char finalGradeLetter;

	
	//set score
	public void setScore(double quizScore1, double quizScore2,
			double midtermScore, double finalScore) {
		this.quiz1Score = quizScore1;
		this.quiz2Score = quizScore2;
		this.midtermScore = midtermScore;
		this.finalScore = finalScore;
	}

	//input scroe
	public void input() {
		double quiz1, quiz2, midterm, finalScore;

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the quiz1 score : ");
		quiz1 = keyboard.nextDouble();
		if (quiz1 > 10 || quiz1 < 0) {
			System.out.println("Score of quiz1 is between 0 to 10");
			System.exit(0);
			//Defensice code.
		}
		System.out.print("Enter the quiz2 score : ");
		quiz2 = keyboard.nextDouble();
		if (quiz2 > 10 || quiz2 < 0) {
			System.out.println("Score of quiz2 is between 0 to 10");
			System.exit(0);
			//Defensice code.
		}
		System.out.print("Enter the midterm score : ");
		midterm = keyboard.nextDouble();
		if (midterm > 100 || midterm < 0) {
			System.out.println("Score of midterm is between 0 to 100");
			System.exit(0);
			//Defensice code.
		}
		System.out.print("Enter the final score : ");
		finalScore = keyboard.nextDouble();
		if (finalScore > 100 || finalScore < 0) {
			System.out.println("Score of quiz1 is between 0 to 100");
			System.exit(0);
			//Defensice code.
		}
		this.setScore(quiz1, quiz2, midterm, finalScore);
		//call metohd setScore

	}

	//Print result
	public void output() {
		this.computeTotalScore();
		this.computeLetterGrade();

		System.out.println("Quiz1 Score : " + this.quiz1Score);
		System.out.println("Quiz2 Score : " + this.quiz2Score);
		System.out.println("Midterm Score : " + this.midtermScore);
		System.out.println("Final Score : " + this.finalScore);
		System.out.println("Total Score : " + this.totalScore);
		System.out.println("Final Grade : " + this.finalGradeLetter);
	}

	//Compute all numeric score
	public void computeTotalScore()// 총점 계산
	{
		this.totalScore = (finalScore * 0.5) + (midtermScore * 0.25)
				+ ((quiz1Score + quiz2Score) * 0.25);
	}

	//Compute grade
	public void computeLetterGrade()// 학점 계산
	{
		if (totalScore >= 90) {
			finalGradeLetter = 'A';
		} else if (totalScore >= 89 && totalScore <= 80) {
			finalGradeLetter = 'B';
		} else if (totalScore >= 79 && totalScore <= 70) {
			finalGradeLetter = 'C';
		} else if (totalScore >= 69 && totalScore <= 60) {
			finalGradeLetter = 'D';
		} else if (totalScore < 60) {
			finalGradeLetter = 'F';
		}
	}

}
