package com.stuff.learn.ds.array;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

	List<E> backedList = new ArrayList<E>();

	public E push(E obj) {
		backedList.add(obj);
		return obj;
	}

	public E pop() throws Exception {
		if (backedList.isEmpty()) {
			throw new Exception("StackUnderFlowError....");
		}
		 E e = backedList.get(backedList.size() - 1);
		 backedList.remove(backedList.size() - 1);
		return e;

	}
	
	public boolean isEmpty() {
		return backedList.isEmpty();
	}

	public static void main(String[] args) throws Exception {
		Stack<String> stack = new Stack<>();
		stack.push("Mallesh");
		stack.push("Data");
		stack.push("Structures");
		System.out.println(stack.pop());
	}

}
