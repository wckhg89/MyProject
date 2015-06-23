import java.util.Scanner;
/**
 * programming project 11_4
 * 200932220 °­È«±¸
 * @author honggu
 *
 */
public class RecursiveSum {
	/**
	 * this method caculate result of sum from input number to zero by reculsively
	 * @param n
	 * @return
	 */
	public static int sum(int num)
	{
		if(num == 0)
		{
			return 0;
		}else
		{
			return(num + sum(num-1));
		}
	}
	
	public static void main(String[] args)
	{
		int num;
		int result;
		Scanner keyboard = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Enter the number of adding to zero : ");
			num = keyboard.nextInt();
			if (num <0)
			{
				System.out.println("End of program");
				System.exit(0);
			}
			result = sum(num);
			System.out.println("Adding from " + num + " to 0 is equal to " + result);
		}
	}
}
