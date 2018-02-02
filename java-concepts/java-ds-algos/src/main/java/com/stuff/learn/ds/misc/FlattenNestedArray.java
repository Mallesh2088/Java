package com.stuff.learn.ds.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] inputArray = new Object[]{1,5,6,7,new Object[]{2,3,4}};
		Integer[] flatten = flatten(inputArray);
		for (Integer integer : flatten) {
			System.out.println(integer);
		}

	}
	
	static Integer[] flatten(Object[] inputArray) {
		
		List<Integer> outPutArrayList = new ArrayList<>();
		if(inputArray == null) return new Integer[0];
		
		for(Object element : inputArray) {
			if(element instanceof Integer) {
				outPutArrayList.add((Integer) element);
			} else if (element instanceof Object[]) {
				outPutArrayList.addAll(Arrays.asList(flatten((Object[])element)));
			}
		}
		Integer[] outputArray = new Integer[outPutArrayList.size()];
		return outputArray = outPutArrayList.toArray(outputArray);
	}

}
