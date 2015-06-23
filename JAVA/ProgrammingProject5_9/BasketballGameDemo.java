import java.util.Scanner;

/**
 * Program to BasketballGameDemo 
 * Author : Kang Hong Gu 
 * Programming Project9 in chapter5 
 * Last Changed : April. 10. 2014
 */

public class BasketballGameDemo {
	public static void main(String[] args) {
		String teamGoal;
		int point = 0;

		BasketballGame test = new BasketballGame();
		// create object BasketballGame.
		Scanner keyboard = new Scanner(System.in);

		test.setName("Korea", "Yonsai");
		// setting name using mutator.
		while (test.getEnd() == false) {
			// looping
			System.out.print("Which team goal ? (Korea or Yeosai)  : ");
			teamGoal = keyboard.next();
			// User input the goal in team.

			System.out.print("What points ? (1~3): ");
			point = keyboard.nextInt();
			// User input the score
			if (point == 1) {
				test.setScorePoint1(teamGoal);
			} else if (point == 2) {
				test.setScorePoint2(teamGoal);

			} else if (point == 3) {
				test.setScorePoint3(teamGoal);

			} else {
				System.out.println("NoNONOOO!!");
				continue;
				// Defensive code.
			}
			System.out.println("Now " + test.getWinTeam() + " is win state.");
			System.out.println("Korea : " + test.getScore("Korea"));
			System.out.println("Yonsai : " + test.getScore("Yonsai"));
			// Print win state.
		}

	}
}
