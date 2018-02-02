package com.stuff.learn.ds.string;

public class StringReverse {

	public static void main(String[] args) {
		System.out.println(reverseStringWithUtil("Geeks for Geeks"));
		System.out.println(reverseStringIterative("Geeks for Geeks"));
		System.out.println(reverseStringSwap("Geeks for Geeks"));
		System.out.println(reverseStringRecursion("Geeks for Geeks"));
	}

	public static String reverseStringWithUtil(String inputString) {
		if (inputString == null)
			return null;
		StringBuilder stringBuilder = new StringBuilder(inputString);
		return stringBuilder.reverse().toString();
	}

	public static String reverseStringIterative(String inputString) {
		char[] charArray = inputString.toCharArray();
		int length = charArray.length;
		char[] outputArray = new char[length];
		int j = 0;
		for (int i = length - 1; i >= 0; i--) {
			outputArray[j] = charArray[i];
			j++;
		}
		return String.valueOf(outputArray);
	}

	public static String reverseStringSwap(String inputString) {
		char[] inputArray = inputString.toCharArray();
		int left = 0, right = inputArray.length -1;
		for(left = 0; left < right; left++, right--) {
			char tempChar = inputArray[left];
			inputArray[left] = inputArray[right];
			inputArray[right] = tempChar;
		}
		return String.valueOf(inputArray);
	}
	
	public static String reverseStringRecursion(String inputString) {
		
		if(inputString == null || inputString.length() <= 1) {
			return inputString;
		} 
		return	reverseStringRecursion(inputString.substring(1)) + inputString.charAt(0) ;
	}

}
