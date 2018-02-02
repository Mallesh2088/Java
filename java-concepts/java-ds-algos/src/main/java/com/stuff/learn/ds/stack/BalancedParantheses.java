package com.stuff.learn.ds.stack;

import com.stuff.learn.ds.array.Stack;

public class BalancedParantheses {

	private static boolean checkParanthesesIfBalanced(String input) throws Exception {

		/* java.util.Stack<Character> stack = new java.util.Stack<>(); */
		Stack<Character> stack = new Stack<>();
		char[] charArray = input.toCharArray();
		for (char c : charArray) {
			if (checkIfCharIsOpenParantheses(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (!isMatchingPair(stack.pop(), c)) {
					return false;
				}

			}
		}

		return stack.isEmpty();
	}

	private static boolean checkIfCharIsOpenParantheses(char c) {
		if (c == '{' || c == '(' || c == '[') {
			return true;
		}
		return false;
	}

	/*
	 * Returns true if character1 and character2 are matching left and right
	 * Parenthesis
	 */
	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		String input = "{[()]}[]";
		System.out.println(checkParanthesesIfBalanced(input));
	}

}
