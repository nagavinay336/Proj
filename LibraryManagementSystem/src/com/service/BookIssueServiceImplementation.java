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
	BookIssueDaoImplementation bookIssueImpl = new BookIssueDaoImplementation();

	@Override
	public String issueBook(int bookId, int accountId)
			throws ClassNotFoundException, SQLException, NumOfBooksLimitExceededException, NoCopiesAvailableException {
		return bookIssueDao.issueBook(bookId, accountId);
	}

	@Override
	public int returnBook(int bookId, int accountId)
			throws ClassNotFoundException, SQLException, IssueDateGreaterException {

		int fine = bookIssueImpl.calculateFine(bookId, accountId);
		int numCopies = bookIssueImpl.numBookAvailable(bookId);
		int numBooks = bookIssueImpl.numOfBooksIssued(accountId);
		if (numBooks > 0) {
			bookIssueImpl.increaseNumBooksAvailable(numCopies, bookId);
			bookIssueImpl.decreaseNumBooksIssued(numBooks, accountId);
			bookIssueImpl.addFine(bookId, accountId, fine);
			bookIssueImpl.setReturned(bookId, accountId);
			return fine;
		}
		return -1;
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
