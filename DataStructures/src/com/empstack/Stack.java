package com.empstack;

public class Stack {

	class Node {
		Employee employee;
		Node next;

		Node(Employee employee) {
			this.employee = employee;
		}
	}

	Node head;
	Node top;

	public void push(Employee emp) {
		Node newEmp = new Node(emp);
		if (top == null) {
			head = newEmp;
			top = newEmp;
		} else {
			Node temp = head;
			while (temp != null) {
				if (temp.employee.equals(emp)) {
					System.out.println("Duplicate entry");
					return;
				}
				temp = temp.next;
			}
			top.next = newEmp;
			top = top.next;
		}
	}

	public void pop() {
		if (top == null) {
			System.out.println("No elements in the stack");
		} else {
			Node temp = head;
			if (head == top) {
				System.out.println(top.employee + " Popped");
				top = null;
			} else {
				while (temp.next != top) {
					temp = temp.next;
				}
				System.out.println(top.employee + " Popped");
				top = temp;
				top.next = null;
			}
		}
	}
}
