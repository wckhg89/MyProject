/**
 * BubbleSort Program.
 * Author : Kang hong gu  
 * Last Changed : May 14. 2014
 */
public class BubbleSort {

	/*
	 * BubbleSort method
	 * : sorting array using bubble sort
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1, arr);
				}
			}
		}
	}

	/*
	 * Swap method
	 * : change array element
	 */
	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
