package com.stuff.learn.ds.searching;

public class LinearSearch {

	public static int searchElement(int[] inputArray, int valueToFind) {

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == valueToFind) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int index = searchElement(new int[] { 10, 2, 3, 4, 5 }, 5);
		if (index == -1) {
			System.out.println("The Given Element is not present.");
		} else {
			System.out.println("The Given Element is present in index :: " + index);
		}
	}

}
