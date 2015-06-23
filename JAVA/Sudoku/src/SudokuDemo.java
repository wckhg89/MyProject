/**
 * Sudoku Program.
 * Author : Kang hong gu  
 * Last Changed : May 14. 2014
 */
import java.util.Scanner;
public class SudokuDemo {
	public static void main(String[] args)
	{
		Sudoku Sudo = new Sudoku();
		Sudo.addInitial(0, 0, 1); Sudo.addInitial(0, 3, 4); Sudo.addInitial(6, 0, 8);
		Sudo.addInitial(0, 1, 2); Sudo.addInitial(0, 4, 9); Sudo.addInitial(7, 0, 7);
		Sudo.addInitial(0, 2, 3); Sudo.addInitial(0, 5, 7); Sudo.addInitial(8, 0, 5);
		Sudo.addInitial(0, 6, 8); Sudo.addInitial(0, 7, 6); Sudo.addInitial(1, 1, 5);
		Sudo.addInitial(0, 8, 5); Sudo.addInitial(1, 0, 4); Sudo.addInitial(1, 2, 9);
		Sudo.addInitial(2, 0, 6); Sudo.addInitial(3, 0, 3); Sudo.addInitial(2, 1, 7);
		Sudo.addInitial(4, 0, 2); Sudo.addInitial(5, 0, 9); Sudo.addInitial(2, 2, 8);
		Sudo.addInitial(5, 5, 5); Sudo.addInitial(8, 3, 9); Sudo.addInitial(3, 4, 1);
		//Make initial sudoku state.
		
		System.out.println("===Start Game!!===");
		Sudo.ToString();
		System.out.println("==================");
		
		Scanner keyboard = new Scanner(System.in);
		while(true)//until full sudoku looping
		{
			int row;
			int col;
			int value;
			int inputValue;
			int selReset=0;
			boolean result=false;
			
			System.out.print("Enter the input row : ");//input col
			row = keyboard.nextInt()-1;
			System.out.print("Enter the input col : ");//input row
			col = keyboard.nextInt()-1;
			System.out.print("Enter the input value : ");//onput value
			value = keyboard.nextInt();
			
			result = Sudo.checkPuzzle(row, col, value);//checking input validity
			if(result==false)//fail
			{
				System.out.println("Input Failed");
			}
			else if(result ==true)//success
			{
				System.out.println("Input Succeed");
			}
			
			System.out.println("==================");
			Sudo.ToString();//print sudoku state of represent
			System.out.println("==================");
			
			
			if(Sudo.isFull()==true)//Success sudoku end looping
			{
				System.out.println("GoodJob Boy! your Puzzle Complete!!");
				break;
			}
			System.out.print("Do you want reset Squares ?  yes->1, no->2 : " );
			//checking reset sudoku
			
			selReset=keyboard.nextInt();
			if(selReset==1)//reset
			{
				Sudo.reset();
				System.out.println("==================");
				Sudo.ToString();
				System.out.println("==================");
			}
			else if(selReset==2)//not reset
			{
				System.out.print("");
			}	
		}
		
	}
}
