package com.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BookIssue;
import com.exceptions.IssueDateGreaterException;
import com.exceptions.NoBooksWithEmployee;
import com.exceptions.NoCopiesAvailableException;
import com.exceptions.NumOfBooksLimitExceededException;

public interface BookIssueDao {

	public String issueBook(int bookId, int accountId)
			throws SQLException, ClassNotFoundException, NumOfBooksLimitExceededException, NoCopiesAvailableException;

	public int returnBook(int bookId, int accountId)
			throws SQLException, ClassNotFoundException, IssueDateGreaterException;

	public ArrayList<BookIssue> listAllBooks(int accountId)
			throws ClassNotFoundException, SQLException, NoBooksWithEmployee;

	public int numOfBooksIssued(int accountId) throws ClassNotFoundException, SQLException;

	public int calculateFine(int bookId, int accountId)
			throws IssueDateGreaterException, ClassNotFoundException, SQLException;
}
