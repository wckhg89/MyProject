/**
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter9
 */

import java.util.Scanner;

public class Calculator {
	private double result;
	private double precision = 0.0001;

	public Calculator() {
		result = 0;
	}

	public void handleDivideByZeroException(DivideByZeroException e) {
		System.out.println("Dividing by zero.");
		System.out.println("Program aborted");
		System.exit(0);
	}

	public void handleUnknownOpException(UnkonwnOpException e) {
		System.out.println(e.getMessage());
		System.out.println("Try again from the beginning:");
		try {
			System.out.print("Format of each line: ");
			System.out.println("operator number");
			System.out.println("For example: + 3");
			System.out.println("To end, enter the letter e.");
			doCalculation();
		} catch (UnkonwnOpException e2) {
			System.out.println(e2.getMessage());
			System.out.println("Try again at some other time.");
			System.out.println("Program ending");
			System.exit(0);
		} catch (DivideByZeroException e3) {
			handleDivideByZeroException(e3);
		}
	}

	public void reset() {
		result = 0;
	}

	public void setResult(double newResult) {
		result = newResult;
	}

	public double getResult() {
		return result;
	}

	public double evaluate(char op, double n1, double n2)
			throws DivideByZeroException, UnkonwnOpException {
		double answer;
		switch (op) {
		case '+':
			answer = n1 + n2;
			break;
		case '-':
			answer = n1 - n2;
			break;
		case '*':
			answer = n1 * n2;
			break;
		case '/':
			if ((-precision < n2) && (n2 < precision))
				throw new DivideByZeroException();
			answer = n1 / n2;
			break;
		default:
			throw new UnkonwnOpException(op);
		}
		return answer;
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
			else {
				double nextNumber = keyboard.nextDouble();
				result = evaluate(nextOp, result, nextNumber);
				System.out.println("result " + nextOp + " " + nextNumber + "="
						+ result);
				System.out.println("updated result = " + result);
			}
		}
	}

	public static void main(String[] args) {
		Calculator clerk = new Calculator();

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
}
