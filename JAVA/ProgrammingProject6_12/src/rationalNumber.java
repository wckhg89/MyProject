/**
 * Author : Kang Hong Gu 
 * Programming Project12 in chapter6
 * Last Changed : April. 28. 2014
 */

public class rationalNumber {
	private int a;// 분자를 받는 member variable.
	private int b;// 분모를 받는 member variable.
	private double rNumber; // 최종 유리수값을 받는 member variable.

	public rationalNumber()// default Constructor.
	{
		rNumber = 0 / 1;
	}

	public rationalNumber(int A, int B)// Constructor : 분자와 분모를 받아서 최종 유리수값
										// setting.
	{
		a = A;
		b = B;
		simplify(a, b);// 최종 유리수값을 만드는 method.
	}

	private void simplify(int a, int b)// simplify method : 최종 유리수값을 만들어주는
										// method.
	{
		int GCD;// 최대공약수를 받기위한 local variable.
		GCD = getGCD(a, b);// getGCD(:a(분자)와 b(분모)의 최대공약수값을 return) method 호출
		if (b > 0) {
			// System.out.println("RationalNumber is " + (a/GCD) + "/" + (b/GCD)
			// + ".");
			rNumber = ((double) (a / GCD)) / ((double) (b / GCD));// rNumber(member
																	// variable
																	// 초기화.)
		}
	}

	private int getGCD(int x, int y)// getGCD method : :a(분자)와 b(분모)의 최대공약수값을
									// return.
	{
		int value; // a(x)와 b(y)를 나눠준 값.
		int remain;// a(x)와 b(y)를 나눠준 나머지값.
		int temp; // y 가 x 보다 클경우 두 variable 을 바꿔주기위한 variable.

		if (y > x)// y 가 x 보다 클경우 두 variable 을 바꿔준다.
		{
			temp = x;
			x = y;
			y = temp;
		}

		value = x / y;// value 값 초기화.
		remain = x % y;// remain 값 초기화.

		if (remain != 0)// 나머지가 0이 아닌경우.
		{
			return getGCD(y, remain);// getGCD method 호출.
		} else if (remain == 0)// 나머지가 0인 경우.
		{
			return y;// y 값을 return 한다.
		}
		return 0;
	}

	public double getValue()// getValue method : 유리수값을 double 값으로 return 하기 위한
							// method.
	{
		return rNumber;// 최종 유리수값 return.
	}

	public String toString()// toString method : 유리수값을 '3/10'같은 형태의 string 값으로
							// return 하기 위한 method.
	{
		String stringA;// 분자값.
		String stringB;// 분모값.
		String result;// 결과값.
		stringA = Integer.toString(a);// 분자의 integer 값을 string 값으로 변환.
		stringB = Integer.toString(b);// 분모의 integer 값을 string 값으로 변환.

		result = stringA + "/" + stringB;// 'a/b'형태로 결과값 초기화.
		return result;// 결과값 return.

	}

}
