package com.sortingbooks;

import java.util.Scanner;

public class BooksSortingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BooksArray ba = new BooksArray();
		System.out.println("Enter the number of Books: ");
		int n = sc.nextInt();
		ba.setN(n);
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the id of book: " + (i + 1));
			int id = sc.nextInt();
			System.out.println("Enter the name of book: " + (i + 1));
			String name = sc.next();
			System.out.println("Enter the name of author: " + (i + 1));
			String author = sc.next();
			System.out.println("Enter the price of book: " + (i + 1));
			double price = sc.nextDouble();
			System.out.println("Enter the number of pages in book: " + (i + 1));
			int noOfPages = sc.nextInt();
			Books b = new Books(id, noOfPages, name, author, price);
			ba.setData(i,b);
		}
		ba.display();
		System.out.println("Sorting the books using number of Pages!!! ");
		ba.sortNoOfPages(ba.getBooks());
		ba.display();
		
		System.out.println("Sorting the books using names of books!!! ");
		ba.sortNameDesc(ba.getBooks());
		ba.display();
		sc.close();
	}

}
