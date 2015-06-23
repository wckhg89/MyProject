/**
 * Author : Kang Hong Gu 
 * Programming Project12 in chapter6
 * Last Changed : April. 28. 2014
 */

import java.util.Scanner;

public class rationalNumberDemo {
	public static void main(String[] args) {
		int a, b;// 분자(a)와 분모(b)값.
		double rationalResult;// 최종 유리수값.
		String rationalResult_s;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the number 'a' : ");
		a = keyboard.nextInt();// a(분자) 초기화.
		System.out.println("Please enter the number 'b' : ");
		b = keyboard.nextInt();// b(분모) 초기화.

		rationalNumber test_Constructor = new rationalNumber(a, b);
		// rationlNumber constructor.

		rationalResult = test_Constructor.getValue();
		// 최종 유리수값 (double) 으로 초기화.
		rationalResult_s = test_Constructor.toString();
		// 최종 유리수값 (string) 으로 초기화.
		System.out.println("Double type RationalNumber is " + rationalResult);
		// 결과값 출력.(double)
		System.out.println("String type RationalNumber is " + rationalResult_s);
		// 결과값 출력.(String)
	}
}
