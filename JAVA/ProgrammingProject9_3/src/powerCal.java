import java.util.Scanner;
/**
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter9
 */

public class powerCal extends Calculator {
	private double result;
	private double memory = 0;

	public static void main(String[] args) {
		Calculator clerk = new powerCal();

		try {
			System.out.println("Calculator is on.");
			System.out.print("Format of each line: ");
			System.out.println("operator space number");
			System.out.println("For example: + 3");
			System.out.println("To end, enter the letter e.");
			clerk.doCalculation();
		} catch (UnkonwnOpException e) {
			clerk.handleUnknownOpException(e);
		} catch (DivideByZeroException e) {
			clerk.handleDivideByZeroException(e);
		}
		System.out.println("The final result is " + clerk.getResult());
		System.out.println("Calculator program ending.");
	}

	public void setResult(double newResult) {
		result = newResult;
	}

	public double getResult() {
		return result;
	}

	public void doCalculation() throws DivideByZeroException,
	UnkonwnOpException {
		Scanner keyboard = new Scanner(System.in);
		boolean done = false;
		result = 0;
		System.out.println("result = " + result);

		while (!done) {
			char nextOp = (keyboard.next()).charAt(0);

			if ((nextOp == 'e') || (nextOp == 'E'))
				done = true;
			else if ((nextOp == 'c') || (nextOp == 'C')) {
				result = 0;
				System.out.println("result = " + result);
			} else if ((nextOp == 'm') || (nextOp == 'M')) {
				memory = result;
				System.out.println("result saved in memory");
			} else if ((nextOp == 'r') || (nextOp == 'R')) {
				System.out.println("recalled memory value = " + memory);
			} else {
				double nextNumber = keyboard.nextDouble();
				result = evaluate(nextOp, result, nextNumber);
				System.out.println("result " + nextOp + " " + nextNumber + "="
						+ result);
				System.out.println("updated result = " + result);
			}
		}
	}

}
