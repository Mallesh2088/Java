package com.stuff.learn.ds.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int index = searchElement(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 12);
		if (index == -1) {
			System.out.println("The Given Element is not present.");
		} else {
			System.out.println("The Given Element is present in index :: " + index);
		}
	}

	private static int searchElement(int[] inputArray, int elementToFind) {
		return inputArray == null || inputArray.length == 0 ? -1
				: binarySearch(inputArray, 0, inputArray.length - 1, elementToFind);
	}

	private static int binarySearch(int[] inputArray, int low, int high, int elementToFind) {

		int mid = (low + high) / 2;
		if (high < low) {
			return -1;
		}

		if (inputArray[mid] == elementToFind) {
			return mid;
		} else if (elementToFind < inputArray[mid]) {
			return binarySearch(inputArray, low, mid - 1, elementToFind);
		} else {
			return binarySearch(inputArray, mid + 1, high, elementToFind);
		}
	}

}
