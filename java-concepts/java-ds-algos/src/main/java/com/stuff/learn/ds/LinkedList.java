package com.stuff.learn.ds;

public class LinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
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
	
	public void printLinkedList(Node head) {
		System.out.println("Nodes of Linked List:: ");
		while (head != null) {
			System.out.println(head.data + "  ");
			head = head.next;
		}
	}

	public void findLength() {
		int counter = 0;
		Node n = head;
		while (n != null) {
			counter++;
			n = n.next;
		}
		System.out.println("Length of Linked List:: " + counter);
	}

	public int findLengthRecursively(Node node) {
		if (node == null)
			return 0;
		return 1 + findLengthRecursively(node.next);
	}

	public int findLengthRec() {
		return findLengthRecursively(head);
	}

	public void insertNodeAtFront(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void insertNodeAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;

	}

	public void insertNodeAfterGivenNode(Node node, int data) {
		if (node == null) {
			System.out.println("The given previous node cannot be null..");
			return;
		}
		Node newNode = new Node(data);
		Node prev_node = head;
		while (prev_node.next != null) {
			prev_node = prev_node.next;
			if (prev_node.data == node.data) {
				newNode.next = prev_node.next;
				prev_node.next = newNode;
				return;
			}

		}

	}

	public void deleteNode(int key) {
		Node temp = head, prev = null;

		// If given key is head
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		// else traverse linked list
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	public void reverseLinkedList() {
		Node current = head;
		Node prev = null, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public Node reverseListRecur(Node head) {
	    if(head==null || head.next == null)
	        return head;
	 
	    //get second node    
	    Node second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    Node rest = reverseListRecur(second);
	    second.next = head;
	    return rest;
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
		linkedList.deleteNode(3);
		linkedList.printLinkedList();
		linkedList.findLength();
		System.out.println("Length of Linked List Recursively :: " + linkedList.findLengthRec());
		linkedList.reverseLinkedList();
		linkedList.printLinkedList();
		linkedList.findLength();
		Node reverseListRecur = linkedList.reverseListRecur(head);
		linkedList.printLinkedList(reverseListRecur);
	}

}
