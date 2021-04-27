package com.unittesting.java.searchAndSort;

public class BubbleSort {

	public static void doBubbleSort(int[] array) {

		int i, j, temp;
		int n = array.length;
		boolean swapped;

		for (i = 0; i < n - 1; i++) {

			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					// swap
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped=true;
				}

			}
			if (swapped == false)
				break;
		}

	}
	
	public static void printArray(int array[]) {
		
		for(int i=0 ; i < array.length;i++) {
			
			System.out.println(array[i]);
		}
	}
	

	public static void main(String[] args) {
		
		int arr[] = {65,20,2,6,90,75};
		doBubbleSort(arr);
		printArray(arr);

	}

}
