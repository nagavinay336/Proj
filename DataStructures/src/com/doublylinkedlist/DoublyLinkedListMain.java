package com.doublylinkedlist;

import java.util.Scanner;

public class DoublyLinkedListMain {

	public static void main(String[] args) {

		DoublyLinkedListPresentation doublyLinkedListPresentation = new DoublyLinkedListPresentation();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			doublyLinkedListPresentation.showMenu();
			System.out.println("Enter choice : ");
			int choice = scanner.nextInt();
			doublyLinkedListPresentation.performMenu(choice);
		}
	}

}
