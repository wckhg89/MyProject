/**
 * Author : Kang Hong Gu 
 * Programming Project12 in chapter6
 * Last Changed : April. 28. 2014
 */

import java.util.Scanner;

public class rationalNumberDemo {
	public static void main(String[] args) {
		int a, b;// ����(a)�� �и�(b)��.
		double rationalResult;// ���� ��������.
		String rationalResult_s;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the number 'a' : ");
		a = keyboard.nextInt();// a(����) �ʱ�ȭ.
		System.out.println("Please enter the number 'b' : ");
		b = keyboard.nextInt();// b(�и�) �ʱ�ȭ.

		rationalNumber test_Constructor = new rationalNumber(a, b);
		// rationlNumber constructor.

		rationalResult = test_Constructor.getValue();
		// ���� �������� (double) ���� �ʱ�ȭ.
		rationalResult_s = test_Constructor.toString();
		// ���� �������� (string) ���� �ʱ�ȭ.
		System.out.println("Double type RationalNumber is " + rationalResult);
		// ����� ���.(double)
		System.out.println("String type RationalNumber is " + rationalResult_s);
		// ����� ���.(String)
	}
}
