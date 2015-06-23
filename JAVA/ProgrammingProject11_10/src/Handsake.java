import java.util.Scanner;

/**
 * programming project 11_10 200932220 °­È«±¸
 * 
 * @author honggu
 * 
 */
public class Handsake {
	/**
	 * this method caculate result of handshake by reculsively
	 * 
	 * @param n
	 * @return
	 */
	public static int handShake(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * handShake(n - 1);
		}
	}

	public static void main(String[] args) {
		int num;
		int result;
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out.print("Enter the number of people : ");
			num = keyboard.nextInt();
			if (num < 1) {
				System.out.println("End of program.");
				System.exit(0);
			}
			if (num == 1) {
				result = 0;
				System.out.println("Result is " + result);
			} else {
				result = handShake(num) / num;

				System.out.println("Result is " + result);
			}

		}
	}
}
