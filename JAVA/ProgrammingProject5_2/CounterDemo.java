/**
 * Program to CounterDemo
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter5
 * Last Changed : April. 10. 2014
 */
public class CounterDemo{
	public static void main(String[] args)
	{
		int count;
		Counter counter_tst = new Counter();
		//Create object
		
		counter_tst.setIncreaseCounter();
		counter_tst.printCounter();
		
	
		counter_tst.setDecreaseCounter();
		counter_tst.printCounter();
		
		counter_tst.setZero();
		count = counter_tst.getCounter();
		
		System.out.println("Result counter by getCounter : " + count);
		counter_tst.printCounter();
	}
}
