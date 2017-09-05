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
		System.out.println("Nodes of Linked List:: ");
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
	
	public void insertNodeAtFront(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertNodeAtEnd(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		
	}
	
	public void insertNodeAfterGivenNode(Node node,int data) {
		if(node == null) {
			System.out.println("The given previous node cannot be null..");
			return;
		}
		Node newNode = new Node(data);
		Node prev_node = head;
		while(prev_node.next != null) {
			prev_node = prev_node.next;
			if(prev_node.data == node.data) {
				newNode.next = prev_node.next;
				prev_node.next = newNode;
				return;
			}
			
		}
		
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
		linkedList.insertNodeAtFront(4);
		linkedList.printLinkedList();
		linkedList.findLength();
		linkedList.insertNodeAtEnd(5);
		linkedList.printLinkedList();
		linkedList.findLength();
		Node prevNode = new Node(3);
		linkedList.insertNodeAfterGivenNode(prevNode, 6);
		linkedList.printLinkedList();
		linkedList.findLength();
	}

}
