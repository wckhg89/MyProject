/**
 * BubbleSort Program.
 * Author : Kang hong gu  
 * Last Changed : May 14. 2014
 */
import java.util.Scanner;
public class InsertionSortDemo {
	public static void main(String[] args) {
		int[] arr;
		int lengthOfArray;
		Scanner keyboard = new Scanner(System.in);
		//enter the length of array
		System.out.print("Enter the length of array : ");
		lengthOfArray = keyboard.nextInt();

		arr = new int[lengthOfArray];
		
		//enter the elements of array
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + i + "th element of array : ");
			arr[i] = keyboard.nextInt();
		}

		//print before sort array
		System.out.println("Not sorted array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		InsertionSort.insertionSort(arr);
		//sort using insertion sort.
		
		//print after sort array
		System.out.println("\nSorted array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
