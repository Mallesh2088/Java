package com.stuff.learn.ds;

public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void printLinkedList() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data + "  ");
			n = n.next;
		}
	}
	
	public void findLength() {
		int counter = 0;
		Node n = head;
		while (n != null) {
			counter ++;
			n = n.next;
		}
		System.out.println("Length of Linked List:: " + counter);
	}

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		linkedList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		linkedList.head.next = second;
		second.next = third;
		linkedList.printLinkedList();
		linkedList.findLength();
	}

}
