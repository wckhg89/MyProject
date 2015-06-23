/**
 * Author : Kang Hong Gu 
 * Programming Project12 in chapter6
 * Last Changed : April. 28. 2014
 */

public class rationalNumber {
	private int a;// ���ڸ� �޴� member variable.
	private int b;// �и� �޴� member variable.
	private double rNumber; // ���� ���������� �޴� member variable.

	public rationalNumber()// default Constructor.
	{
		rNumber = 0 / 1;
	}

	public rationalNumber(int A, int B)// Constructor : ���ڿ� �и� �޾Ƽ� ���� ��������
										// setting.
	{
		a = A;
		b = B;
		simplify(a, b);// ���� ���������� ����� method.
	}

	private void simplify(int a, int b)// simplify method : ���� ���������� ������ִ�
										// method.
	{
		int GCD;// �ִ������� �ޱ����� local variable.
		GCD = getGCD(a, b);// getGCD(:a(����)�� b(�и�)�� �ִ��������� return) method ȣ��
		if (b > 0) {
			// System.out.println("RationalNumber is " + (a/GCD) + "/" + (b/GCD)
			// + ".");
			rNumber = ((double) (a / GCD)) / ((double) (b / GCD));// rNumber(member
																	// variable
																	// �ʱ�ȭ.)
		}
	}

	private int getGCD(int x, int y)// getGCD method : :a(����)�� b(�и�)�� �ִ���������
									// return.
	{
		int value; // a(x)�� b(y)�� ������ ��.
		int remain;// a(x)�� b(y)�� ������ ��������.
		int temp; // y �� x ���� Ŭ��� �� variable �� �ٲ��ֱ����� variable.

		if (y > x)// y �� x ���� Ŭ��� �� variable �� �ٲ��ش�.
		{
			temp = x;
			x = y;
			y = temp;
		}

		value = x / y;// value �� �ʱ�ȭ.
		remain = x % y;// remain �� �ʱ�ȭ.

		if (remain != 0)// �������� 0�� �ƴѰ��.
		{
			return getGCD(y, remain);// getGCD method ȣ��.
		} else if (remain == 0)// �������� 0�� ���.
		{
			return y;// y ���� return �Ѵ�.
		}
		return 0;
	}

	public double getValue()// getValue method : ���������� double ������ return �ϱ� ����
							// method.
	{
		return rNumber;// ���� �������� return.
	}

	public String toString()// toString method : ���������� '3/10'���� ������ string ������
							// return �ϱ� ���� method.
	{
		String stringA;// ���ڰ�.
		String stringB;// �и�.
		String result;// �����.
		stringA = Integer.toString(a);// ������ integer ���� string ������ ��ȯ.
		stringB = Integer.toString(b);// �и��� integer ���� string ������ ��ȯ.

		result = stringA + "/" + stringB;// 'a/b'���·� ����� �ʱ�ȭ.
		return result;// ����� return.

	}

}
