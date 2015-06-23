
/**
 * Author : Kang Hong Gu 
 * Programming Project4 in chapter6
 * Last Changed : April. 28. 2014
 */

public class DollarFormat {
	
	//write method
	public static void write(double amount) {
		if (amount >= 0) {
			System.out.print('$');
			writePositive(amount);
		} else {
			double positiveAmount = amount;
			System.out.print('$');
			System.out.print('-');
			System.out.print(positiveAmount);
		}
	}

	//writePositive method
	private static void writePositive(double amount) {
		int allCents = (int) Math.floor(amount * 100);
		//floor the .xxx
		int dollars = allCents / 100;
		int cents = allCents % 100;

		System.out.print(dollars);
		System.out.print('.');

		if (cents < 10) {
			System.out.print('0');
		}
		System.out.print(cents);
	}

	public static void writeln(double amount) {
		write(amount);
		System.out.println();
	}
}
