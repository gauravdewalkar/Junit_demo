package com.unittesting.java.searchAndSort;

public class BinarySearch {

	public int binarySearch(int arr[], int l, int h, int x) {

		if (h >= l) {
			int mid = l + (h - l) / 2;

			if (arr[mid] == x)
				return mid;

			if (arr[mid] < x) {
				return binarySearch(arr, mid + 1, h, x);
			}
			if (arr[mid] > x) {
				return binarySearch(arr, l, mid - 1, x);
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();

		int array[] = { 10, 47, 64, 9, 65, 4 };
		int n = array.length;
		int x = 9;
		int result = b.binarySearch(array, 0, n - 1, x);

		if (result == -1)
			System.out.println(" number not found");

		else

			System.out.println("number found at position :" + result);

	}

}
