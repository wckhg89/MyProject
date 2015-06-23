/**
 * InsertionSort Program.
 * Author : Kang hong gu  
 * Last Changed : May 14. 2014
 */
public class InsertionSort {
	
	/*
	 * Insertion sort method
	 * : sorting array using insertion sort
	 */
	public static void insertionSort(int[] arr) {
		int temp;
		int pos;

		for (int i = 1; i < arr.length; i++) {
			temp = arr[i];
			pos = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
					pos = j;
				}
			}
			arr[pos] = temp;
		}
	}
}
