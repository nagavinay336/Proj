package com.doublylinkedlist;

import java.util.Scanner;

public class DoublyLinkedListPresentation {

	DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

	public void showMenu() {
		System.out.println("1. Add element to the beginning of Linked List");
		System.out.println("2. Add element to the end of Linked List");
		System.out.println("3. Traverse Linked List");
		System.out.println("4. Reverse Traverse Linked List");
		System.out.println("5. Deleting data fron  List");
		System.out.println("6. Exit");
	}

	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.println("Enter person id : ");
			int id = scanner.nextInt();
			System.out.println("Enter person name : ");
			String name = scanner.next();
			Person person = new Person(id, name);
			doublyLinkedList.insertFirst(person);
			break;
		case 2:
			System.out.println("Enter person id : ");
			int idl = scanner.nextInt();
			System.out.println("Enter person name : ");
			String namel = scanner.next();
			Person personl = new Person(idl, namel);
			doublyLinkedList.insertLast(personl);
			break;
		case 3:
			doublyLinkedList.traverse();
			break;
		case 4:
			doublyLinkedList.reverseTraversal();
			break;
		case 5:
			System.out.println("Enter id to be deleted : ");
			int ele = scanner.nextInt();
			doublyLinkedList.delete(ele);
			break;

		case 6:
			System.out.println("Thanks for Using out System");
			System.exit(0);
		default:
			break;
		}
	}
}
