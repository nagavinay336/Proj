package com.doublylinkedlist;

public class DoublyLinkedList {

	class Node {
		Person person;
		Node next;
		Node previous;

		public Node(Person person) {
			this.person = person;
			next = null;
			previous = null;
		}
	}

	Node head, last;

	public void insertFirst(Person person) {
		Node newNode = new Node(person);
		if (head == null) {
			head = newNode;
			last = head;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		System.out.println("Insertion Successful");
	}

	public void insertLast(Person person) {
		Node newNode = new Node(person);
		if (head == null) {
			head = newNode;
			last = head;
		}

		else {
			newNode.previous = last;
			last.next = newNode;
			last = last.next;
		}
		System.out.println("Insertion Successful");
	}

	public void traverse() {

		Node temp = head;
		while (temp != null) {
			System.out.println(temp.person);
			temp = temp.next;
		}
	}

	public void reverseTraversal() {

		Node temp = last;
		while (temp != null) {
			System.out.println(temp.person);
			temp = temp.previous;
		}
	}

	public void delete(int id) {
		Node temp = head;
		if (head != null) {
			if (head.person.getPersonId() == id) {
				head = head.next;
				head.previous = null;
			} else {
				while (temp.next != null && temp.next.person.getPersonId() != id) {
					temp = temp.next;
				}
				if (temp.next != null) {
					temp.next = temp.next.next;
				} else {
					System.out.println("There is no such Id");
				}
			}
		}
	}
}
