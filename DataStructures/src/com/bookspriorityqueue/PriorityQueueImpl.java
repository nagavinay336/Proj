package com.bookspriorityqueue;

public class PriorityQueueImpl {
	class Node {
		Books book;
		Node next;
		Node previous;

		Node(Books book) {
			this.book = book;
		}
	}

	Node head;

	public void insert(Books book) {
		Node newNode = new Node(book);
		if (head == null) {
			head = newNode;
		} else if (head.book.getPrice() > book.getPrice()) {
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			Node prev = head;
			while (temp != null) {
				if (temp.book.getPrice() < book.getPrice()) {
					prev = temp;
					temp = temp.next;
				} else {
					break;
				}
			}
			if (prev.next == null) {
				prev.next = newNode;
				newNode.previous = prev;
			} else {
				prev.next = newNode;
				newNode.previous = prev;
				newNode.next = temp;
				temp.previous = newNode;
			}
		}
	}

	public void traverse() {

		if (head == null) {
			System.out.println("No elements to traverse");
		}
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.book);
			temp = temp.next;
		}
	}

	public void delete() {
		if (head == null) {
			System.out.println("No elements in Queue to delete");
			return;
		}
		System.out.println(head.book + " Deleted");
		head = head.next;
		if (head != null) {
			head.previous = null;
		}
	}

}
