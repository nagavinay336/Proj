package com.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.EmployeeAccount;
import com.exceptions.AccountAlreadyExists;
import com.exceptions.IssueDateGreaterException;
import com.exceptions.NoBooksWithEmployee;
import com.exceptions.NoCopiesAvailableException;
import com.exceptions.NumOfBooksLimitExceededException;
import com.service.*;
import com.bean.Book;
import com.bean.BookIssue;

public class EmployeePresentationImplementation implements EmployeePresentation {

	private BookIssueService bookIssueService = new BookIssueServiceImplementation();
	private BookService bookService = new BookServiceImplementation();
	private EmployeeAccountService employeeAccountService = new EmployeeAccountServiceImplementation();
	private EmployeeService employeeService = new EmployeeServiceImplementation();

	Scanner sc = new Scanner(System.in);

	@Override
	public void showMenu(int accountId) {
		boolean check = false;
		try {
			check = employeeAccountService.accountExists(accountId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check) {
			System.out.println("1. Issue Book");
			System.out.println("2. Return Book");
			System.out.println("3. Check account Details");
			System.out.println("4. List All Books in the library");
			System.out.println("5. List of Books You have");
			System.out.println("6. Exit");
//		System.out.println("7. Create new Library Id");
			System.out.println("Enter choice: ");
			int choice = sc.nextInt();
			performMenu(choice, accountId);
			showMenu(accountId);
		} else {
			System.out.println("Library Account Id entered is wrong please enter correct Id: ");
			accountId = sc.nextInt();
			showMenu(accountId);
		}
	}

	@Override
	public void performMenu(int choice, int accountId) {

		int bookId;
		boolean res = false;
		ArrayList<Book> books;
		ArrayList<BookIssue> bookIssue;
		switch (choice) {
		case 1:
			System.out.println("You have selected issue book\nThese are the list of books available in library: ");
			books = null;
			try {
				books = bookService.listAllBooks();
				for (Book b : books) {
					System.out.println("Book Id : " + b.getBookId());
					System.out.println("Book Name : " + b.getBookName());
					System.out.println("Author Name : " + b.getAuthorName());
					System.out.println("Book Type : " + b.getType());
					System.out.println("Number of copies of Book : " + b.getNumOfCopies());
					System.out.println();
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			System.out.print("Number of book issued to you are : ");
			try {
				int numOfBooksIss = bookIssueService.numOfBooksIssued(accountId);
				if (numOfBooksIss == 5) {
					System.out.println(
							"5 books. \nBooks can't be issued to you.\nReturn a existing book to get new book\n");

					break;
				} else {
					System.out.println("" + numOfBooksIss + " You can borrow: " + (5 - numOfBooksIss) + " more books");
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			System.out.println("\n");
			System.out.println("Enter id of the book: ");
			bookId = sc.nextInt();

			String date = "";
			try {
				try {
					date = bookIssueService.issueBook(bookId, accountId);
				} catch (NumOfBooksLimitExceededException e) {
					System.out.println(e.getMessage());
				} catch (NoCopiesAvailableException e) {
					System.out.println(e.getMessage());
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if (date.length() != 0) {
				System.out.println("Book Issue Successful.\nExpected Return Date is: " + date);
			} else {
				System.out.println("Book issue Failed");
			}
			System.out.println("\n");
			break;
		case 2:
			System.out.println("You have selected return book\n");
			bookIssue = null;
			try {
				bookIssue = bookIssueService.listAllBooks(accountId);
				System.out.println("List of Books you have are: ");
				for (BookIssue bi : bookIssue) {
					System.out.println("Book ID: " + bi.getBookId());
					System.out.println("Issue Date: " + bi.getIssueDate());
					System.out.println("Expected Return Date: " + bi.getReturnDate());
					System.out.println();
				}

			} catch (NoBooksWithEmployee e) {
				System.out.println(e.getMessage());
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Enter id of the book: ");
			bookId = sc.nextInt();

			int fine = 0;
			try {
				fine = bookIssueService.returnBook(bookId, accountId);
				if (fine == -1) {
					System.out.println("There was an error while returning your book.\nTry Again");
				} else if (fine == 0) {
					System.out.println("Thank you for returning the book within the return duration");
				} else {
					System.out.println("Your fine is: " + fine);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (IssueDateGreaterException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("\n");
			break;
		case 3:
			System.out.println("You have selected check your details\n");

			EmployeeAccount empAcc = null;
			try {
				empAcc = employeeAccountService.getEmployeeAccountDetail(accountId);
				System.out.println("Your Account details are: ");
				System.out.println("Accout Id : " + empAcc.getAccountId());
				System.out.println("Number of Books you currently have are: " + empAcc.getNumOfBooks());
				System.out.println("Your Employee ID : " + empAcc.getEmployeeId());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\n");
			break;
		case 4:
			System.out.println("You have selected List all Books\n");

			books = null;
			try {
				books = bookService.listAllBooks();
				for (Book b : books) {
					System.out.println("Book Id : " + b.getBookId());
					System.out.println("Book Name : " + b.getBookName());
					System.out.println("Author Name : " + b.getAuthorName());
					System.out.println("Book Type : " + b.getType());
					System.out.println("Number of copies of Book : " + b.getNumOfCopies());
					System.out.println();
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\n");
			break;
		case 7:
			System.out.println("You have selected create new library id\nEnter id of the employee: ");
			int empId = sc.nextInt();
			boolean check = false;
			try {
				check = employeeService.employeeExists(empId);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			if (check) {
				int libId = empId * 10 + 1;

				EmployeeAccount empAcc1 = new EmployeeAccount(libId, 0, empId);
				res = false;
				try {
					res = employeeAccountService.createEmployeeAccount(empAcc1);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} catch (AccountAlreadyExists e) {
					System.out.println(e.getMessage());
					break;
				}
				if (res) {
					System.out.println("Account Creation Successful");
					System.out.println("Your Library Id is: " + libId);
					System.out.println("Now you can login into your account\nEnter acountId");
					accountId = sc.nextInt();
					showMenu(accountId);
				} else {
					System.out.println("Account Creation Failed");
				}
				System.out.println("\n");
				break;
			} else {
				System.out.println("The Employee Id doesn't Exists.\nDo you want to try another Id : Press 1");
				int ch = sc.nextInt();
				if (ch == 1) {
					performMenu(7, 0);
				} else {
					System.out.println("\n");
					break;
				}
			}
//		case 6:
//			System.out.println(
//					"You have selected delete existing library id\nEnter library account id of the employee: ");
//			int libAccId = sc.nextInt();
//			res = false;
//			try {
//				res = employeeAccountService.deleteEmployeeAccount(libAccId);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			if (res) {
//				System.out.println("Account Deletion Successful");
//			} else {
//				System.out.println("Account Deletion Failed");
//			}
//			System.out.println("\n");
//			break;

		case 5:
			System.out.println("You have selected to list all books: \n");
			bookIssue = null;
			try {
				bookIssue = bookIssueService.listAllBooks(accountId);
				System.out.println("List of Books you have are: ");
				for (BookIssue bi : bookIssue) {
					System.out.println("Book ID: " + bi.getBookId());
					System.out.println("Issue Date: " + bi.getIssueDate());
					System.out.println("Expected Return Date: " + bi.getReturnDate());
					System.out.println();
				}

			} catch (NoBooksWithEmployee e) {
				System.out.println(e.getMessage());
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\n");
			break;
		case 6:
			System.out.println("Thank you for using library management system!!\nVisit Again");
			System.out.println("\n");
			System.exit(0);
		default:
			System.out.println("Select correct option");
			System.out.println("\n");
		}

	}
}
