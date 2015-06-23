import java.util.Scanner;
/**
 * programming project 11_3
 * 200932220 °­È«±¸
 * @author honggu
 *
 */
public class Factorial {
	/**
	 * this method caculate result of factorial number by reculsively
	 * @param n
	 * @return
	 */
	public static int factorial(int num) {
		if (num == 0) {

			return 1;
		} else {

			return num * factorial(num - 1);
		}
	}

	public static void main(String[] args) {
		int num = 0;
		int result = 0;
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out.print("Enter the number of factorial : ");
			num = keyboard.nextInt();
			if (num < 0) {
				System.out.println("End of program.");
				System.exit(0);
			}
			result = factorial(num);

			System.out.println(num + "! is equal to " + result);
		}
	}
}
