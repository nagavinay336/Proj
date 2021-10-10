package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BookIssue;
import com.exceptions.IssueDateGreaterException;
import com.exceptions.NoBooksWithEmployee;
import com.exceptions.NoCopiesAvailableException;
import com.exceptions.NumOfBooksLimitExceededException;
import com.persistance.BookIssueDao;
import com.persistance.BookIssueDaoImplementation;

public class BookIssueServiceImplementation implements BookIssueService {

	BookIssueDao bookIssueDao = new BookIssueDaoImplementation();

	@Override
	public String issueBook(int bookId, int accountId)
			throws ClassNotFoundException, SQLException, NumOfBooksLimitExceededException, NoCopiesAvailableException {
		return bookIssueDao.issueBook(bookId, accountId);
	}

	@Override
	public int returnBook(int bookId, int accountId)
			throws ClassNotFoundException, SQLException, IssueDateGreaterException {
		return bookIssueDao.returnBook(bookId, accountId);
	}

	@Override
	public ArrayList<BookIssue> listAllBooks(int accountId)
			throws ClassNotFoundException, SQLException, NoBooksWithEmployee {
		return bookIssueDao.listAllBooks(accountId);
	}

	@Override
	public int numOfBooksIssued(int accountId) throws ClassNotFoundException, SQLException {
		return bookIssueDao.numOfBooksIssued(accountId);
	}

}
