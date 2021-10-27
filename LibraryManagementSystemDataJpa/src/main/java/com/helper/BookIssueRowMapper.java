package com.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.BookIssue;

public class BookIssueRowMapper implements RowMapper<BookIssue> {

	@Override
	public BookIssue mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int bookId = resultSet.getInt("Book_id");
		int accountId = resultSet.getInt("ACCOUNT_ID");
		String issueDate = resultSet.getString("ISSUE_DATE");
		String returnDate = resultSet.getString("RETURN_DATE");
		int fineForBook = resultSet.getInt("FINE_FOR_BOOK");
		boolean returnedStatus = resultSet.getBoolean("RETURNED_STATUS");
		BookIssue book = new BookIssue(bookId, accountId, fineForBook, issueDate, returnDate, returnedStatus);
		return book;
	}

}
