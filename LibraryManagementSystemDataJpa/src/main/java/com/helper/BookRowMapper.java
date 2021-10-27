package com.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int bookId = resultSet.getInt("Book_id");
		String bookName = resultSet.getString("Book_name");
		String authorName = resultSet.getString("Author_name");
		String type = resultSet.getString("Type");
		int numOfCopies = resultSet.getInt("NUM_OF_COPIES");
		Book book = new Book(bookId, numOfCopies, bookName, authorName, type);
		return book;
	}

}
