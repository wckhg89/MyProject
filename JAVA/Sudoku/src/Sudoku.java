/**
 * Sudoku Program.
 * Author : Kang hong gu  
 * Last Changed : May 14. 2014
 */
public class Sudoku {
	private int[][] board;
	private int[][] Reset;
	private boolean[][] start;
	private boolean[][] resetStart;
	
	public Sudoku()//constructor
	{
		board = new int[9][9];
		Reset = new int[9][9];
		start = new boolean[9][9];
		resetStart = new boolean[9][9];
		
		for(int i=0 ; i<9 ; i++)
			for(int j=0; j<9 ; j++){
				start[i][j]=false;
				resetStart[i][j]=false;
			}
	}
	
	public void ToString()//printing sudoku state of represent
	{	
		for(int i=0 ; i < board[0].length ; i++)
		{
			for(int j=0 ; j < board.length ; j++)
				System.out.print(board[i][j]+ " ");
		System.out.println("");
		}
		
	}
	public void addInitial(int row, int col, int value)//create initial array 
	{
			board[row][col]=value;
			Reset[row][col]=value;
			start[row][col]=true;
			resetStart[row][col]=true;
	}
	
	public boolean checkPuzzle(int row, int col, int value)
	{
		//check col 1 to 9
		for(int i=0 ; i < board[row].length ; i++)
		{
			if(getValueIn(row,i) == value)
				return false;
			
		}
		//check row 1 to 9
		for(int i=0; i< board.length ; i++)
		{
			if(getValueIn(i,col) == value)
				return false;
			
		}
		//check 3X3 1 to 9
		int sx= ((int)(row/3))*3;
		int ex= sx+3;
		int sy = ((int)(col/3))*3;
		int ey = sy+3;
		for(int i=sx ; i<ex ; i++)
		{
			for(int j=sy ; j<ey ; j++)
			{
				if(getValueIn(i,j) == value)
					return false;
				
			}
		}
		//check value
		if(start[row][col]==true)
			return false;
		
		addGuess(row,col,value);
		return true;
	}
	public void addGuess(int row, int col, int value)
	{
		board[row][col]=value;
		start[row][col]=true;
	}
	public int getValueIn(int row, int col)
	{
		return board[row][col];
	}
	
	public boolean isFull()//check full sudoku
	{
		for(int i=0 ; i < start[0].length ; i++)
			for(int j=0 ; j < start.length ; j++)
				if(start[i][j]!=true)
					return false;
		return true;								
	}
	
	public void reset()//reset sudoku
	{
		for(int i=0 ; i<9 ; i++)
			for(int j=0 ; j<9 ; j++){
				board[i][j]=Reset[i][j];
				start[i][j]=resetStart[i][j];
			}
	}
}

