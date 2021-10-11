package com.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.bean.BookIssue;
import com.exceptions.IssueDateGreaterException;
import com.exceptions.NoBooksWithEmployee;
import com.exceptions.NoCopiesAvailableException;
import com.exceptions.NumOfBooksLimitExceededException;

public class BookIssueDaoImplementation implements BookIssueDao {

	@Override
	public String issueBook(int bookId, int accountId)
			throws SQLException, ClassNotFoundException, NumOfBooksLimitExceededException, NoCopiesAvailableException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");
		PreparedStatement preparedStatement;
		int numCopies = numBookAvailable(bookId);
		int numBooks = numOfBooksIssued(accountId);

//		LocalDate currentDate=LocalDate.now();
//		if(currentDate<issueDate) {
//			throw new IssueDateGreaterException("Issue Date is greater than Current Date");
//		}
		if (numBooks >= 5) {
			throw new NumOfBooksLimitExceededException(
					"You have maximum number of Books i.e. 5. Please return existing book and then try issuing new book again");
		}
		if (numCopies <= 0) {
			throw new NoCopiesAvailableException("This book is currently unavailable try another book. Thank you.");
		}
		if (numCopies > 0) {
			decreaseNumBooksAvailable(numCopies, bookId);

			preparedStatement = connection.prepareStatement("Insert into Books_issue values(?,?,?,?,?,?)");

			LocalDate currentDate = LocalDate.now();
			LocalDate d1 = currentDate.plusDays(7);
			preparedStatement.setInt(1, bookId);
			preparedStatement.setInt(2, accountId);
			preparedStatement.setString(3, currentDate.toString());
			preparedStatement.setString(4, d1.toString());
			preparedStatement.setInt(5, 0);
			preparedStatement.setBoolean(6, false);
			preparedStatement.executeUpdate();
			increaseNumBooksIssued(numBooks, accountId);
			return d1.toString();
		}
		return "";
	}

	@Override
	public int returnBook(int bookId, int accountId)
			throws SQLException, ClassNotFoundException, IssueDateGreaterException {
//		int fine = calculateFine(bookId, accountId);
//		int numCopies = numBookAvailable(bookId);
//		int numBooks = numOfBooksIssued(accountId);
//		if (numBooks > 0) {
//			increaseNumBooksAvailable(numCopies, bookId);
//			decreaseNumBooksIssued(numBooks, accountId);
//			addFine(bookId, accountId, fine);
//			setReturned(bookId, accountId);
//			return fine;
//		}
//		return -1;
		return 0;
	}

	public void setReturned(int bookId, int accountId) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection.prepareStatement(
				"update books_issue set Returned_status= ? where book_id= ? and account_id= ? and returned_status= ? ");
		preparedStatement.setBoolean(1, true);
		preparedStatement.setInt(2, bookId);
		preparedStatement.setInt(3, accountId);
		preparedStatement.setBoolean(4, false);
		preparedStatement.executeUpdate();

	}

	public int numBookAvailable(int bookId) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

//		BookCopies bookCopies=new BookCopies();
		PreparedStatement preparedStatement = connection.prepareStatement("Select * from book where book_id=?");
		preparedStatement.setInt(1, bookId);
		ResultSet resultSet = preparedStatement.executeQuery();
		int numCopies = 0;
		// 3.Process Result
		while (resultSet.next()) {
			numCopies = resultSet.getInt("NUM_OF_COPIES");
		}
		if (numCopies > 0) {
			return numCopies;
		}
		return 0;
	}

	public void decreaseNumBooksAvailable(int numCopies, int bookId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("update book set NUM_OF_COPIES= ? where book_id= ? ");
		preparedStatement.setInt(1, numCopies - 1);
		preparedStatement.setInt(2, bookId);
		preparedStatement.executeUpdate();
	}

	public void increaseNumBooksAvailable(int numCopies, int bookId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("update book set NUM_OF_COPIES= ? where book_id= ? ");
		preparedStatement.setInt(1, numCopies + 1);
		preparedStatement.setInt(2, bookId);
		preparedStatement.executeUpdate();
	}

	public int numOfBooksIssued(int accountId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM EMPLOYEE_ACCOUNT where LIBRARY_ACC_ID= ? ");
		preparedStatement.setInt(1, accountId);
		ResultSet resultSet = preparedStatement.executeQuery();
		int res = 0;
		while (resultSet.next()) {
			res = resultSet.getInt("NUM_OF_BOOKS_WITH_EMPLOYEE");
		}
		return res;
	}

	public void decreaseNumBooksIssued(int numBooks, int accountId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("update employee_account set NUM_OF_BOOKS_WITH_EMPLOYEE= ? where LIBRARY_ACC_ID= ? ");
		preparedStatement.setInt(1, (numBooks - 1));
		preparedStatement.setInt(2, accountId);
		preparedStatement.executeUpdate();
	}

	public void increaseNumBooksIssued(int numBooks, int accountId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("update employee_account set NUM_OF_BOOKS_WITH_EMPLOYEE= ? where LIBRARY_ACC_ID= ? ");
		preparedStatement.setInt(1, (numBooks + 1));
		preparedStatement.setInt(2, accountId);
		preparedStatement.executeUpdate();
	}

	public int addFine(int bookId, int accountId, int fine) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection.prepareStatement(
				"update books_issue set FINE_FOR_BOOK= ? where book_id= ? and account_id= ? and returned_status=false");
		preparedStatement.setInt(1, fine);
		preparedStatement.setInt(2, bookId);
		preparedStatement.setInt(3, accountId);
		return preparedStatement.executeUpdate();
	}

	public ArrayList<BookIssue> listAllBooks(int accountId)
			throws ClassNotFoundException, SQLException, NoBooksWithEmployee {
		ArrayList<BookIssue> bookIssue = new ArrayList<BookIssue>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM BOOKS_ISSUE where ACCOUNT_ID= ? and returned_status= ? ");
		preparedStatement.setInt(1, accountId);
		preparedStatement.setBoolean(2, false);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.getFetchSize() > 0) {
			throw new NoBooksWithEmployee("You don't have any books with you");
		}
		while (resultSet.next()) {
			int bookId = resultSet.getInt("Book_ID");
			int empAccountId = resultSet.getInt("ACCOUNT_ID");
			String issueDate = resultSet.getString("ISSUE_DATE");
			String returnDate = resultSet.getString("RETURN_DATE");
			int fine = resultSet.getInt("FINE_FOR_BOOK");
			boolean returnStatus = resultSet.getBoolean("Returned_Status");
			BookIssue bi = new BookIssue(bookId, empAccountId, fine, bookId, issueDate, returnDate, returnStatus);
			bookIssue.add(bi);
		}
		return bookIssue;
	}

	public int calculateFine(int bookId, int accountId)
			throws IssueDateGreaterException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection.prepareStatement(
				"SELECT * FROM BOOKS_ISSUE where BOOK_ID= ? and Account_id= ? and returned_status= ? ");
		preparedStatement.setInt(1, bookId);
		preparedStatement.setInt(2, accountId);
		preparedStatement.setBoolean(3, false);
		ResultSet resultSet = preparedStatement.executeQuery();
		String issueDate = "", returnDate = "";

		while (resultSet.next()) {
			issueDate = resultSet.getString("ISSUE_Date");
			returnDate = resultSet.getString("return_Date");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localIssueDate = LocalDate.parse(issueDate, formatter);
		LocalDate localReturnDate = LocalDate.parse(returnDate, formatter);
		LocalDate currentDate = LocalDate.now();
		if (localIssueDate.isAfter(currentDate)) {
			throw new IssueDateGreaterException("Issue date is greater then the current date.");
		}
		if (localReturnDate.isAfter(currentDate) || localReturnDate.equals(currentDate)) {
			// fine is 0 because the book was returned early or on time
			return 0;
		}
		int diff = currentDate.getDayOfYear() - localReturnDate.getDayOfYear();
		preparedStatement = connection.prepareStatement("SELECT * FROM BOOK where BOOK_ID= ? ");
		preparedStatement.setInt(1, bookId);
		resultSet = preparedStatement.executeQuery();
		String type = "";
		while (resultSet.next()) {
			type = resultSet.getString("TYPE");
		}
		int fine = 0;
		if (type.equals("Data Analytics")) {
			fine = diff * 5;
		} else if (type.equals("Technology")) {
			fine = diff * 6;
		} else {
			fine = diff * 7;
		}
		return fine;
	}
}
