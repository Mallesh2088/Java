package com.stuff.learn.ds.array;

public class ArrayRotation {
	
	public static int[] leftRotateUsingTempArray(int[] inputArray, int d, int n) {
		
		if(d > n )
			return inputArray;
		
		int[] temp = new int[n];
		for(int i = 0; i < d; i++) {
			temp[i] = inputArray[i];
		}
		
		int j=0;
		for(int i=d; i<n;i++) {
			inputArray[j] = inputArray[i];
			j++;
		}
		
		int k=0;
		for(int i=n-d; i < n;i++) {
			inputArray[i] = temp[k];
			k++;
		}
		return inputArray;
	}
	
	public static int[] leftRotateUsingTemp(int[] inputArray, int d, int n) {
		
		if(d > n )
			return inputArray;
		
		int temp;
		for(int i=0; i <d; i++) {
			temp = inputArray[0];
			for(int j=0; j < n -1 ;j++) {
				inputArray[j] = inputArray[j+1];
			}
			inputArray[n-1] = temp;
		}
		
		
		return inputArray;
	}
	public static void main(String[] args) {
		
		int[] inputArray =  new int[]{1,2,3,4,5,6,7};
		int d = 2;
		int n= 7;
		int[] leftRotateUsingTemp = leftRotateUsingTempArray(inputArray,d,n);
		for (int i : leftRotateUsingTemp) {
			System.out.println(i);
		}
		System.out.println("----------------------");
		
		int[] leftRotate = leftRotateUsingTemp(new int[]{1,2,3,4,5,6,7},d,n);
		for (int i : leftRotate) {
			System.out.println(i);
		}
		System.out.println("----------------------");
	}

}
