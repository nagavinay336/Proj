package com.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Book;

public class BookDaoImplementation implements BookDao {

	@Override
	public void addBook(Book b) {

	}

	@Override
	public ArrayList<Book> listAllBooks() throws SQLException, ClassNotFoundException {
		ArrayList<Book> books = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection.prepareStatement("Select * from book");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int bookId = resultSet.getInt("Book_id");
			String bookName = resultSet.getString("Book_name");
			String authorName = resultSet.getString("Author_name");
			String type = resultSet.getString("Type");
			int numOfCopies = resultSet.getInt("NUM_OF_COPIES");
			Book b = new Book(bookId, numOfCopies, bookName, authorName, type);
			books.add(b);
		}
		return books;
	}

}
