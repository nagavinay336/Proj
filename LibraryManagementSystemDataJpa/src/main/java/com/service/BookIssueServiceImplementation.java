package com.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.BookIssue;
import com.exceptions.IssueDateGreaterException;
import com.exceptions.NoCopiesAvailableException;
import com.exceptions.NumOfBooksLimitExceededException;
import com.persistence.BookIssueDao;

@Service
public class BookIssueServiceImplementation implements BookIssueService {

	@Autowired
	BookIssueDao bookIssueDao;

//	public BookIssueServiceImplementation(BookIssueDao bookIssueDao) {
//		super();
//		this.bookIssueDao = bookIssueDao;
//	}

	@Override
	public String issueBook(int bookId, int accountId, int numBooks, int numCopies)
			throws NumOfBooksLimitExceededException, NoCopiesAvailableException {
		if (numBooks >= 5) {
			throw new NumOfBooksLimitExceededException(
					"You have maximum number of Books i.e. 5. Please return existing book and then try issuing new book again");
		}
		if (numCopies <= 0) {
			throw new NoCopiesAvailableException("This book is currently unavailable try another book. Thank you.");
		}
		bookIssueDao.save(new BookIssue(bookId, accountId, 0, LocalDate.now().toString(), LocalDate.now().plusDays(7).toString(), false));
		return LocalDate.now().plusDays(7).toString();
	}

	@Override
	public int returnBook(int bookId, int accountId, String type, int numBooks) throws IssueDateGreaterException {

		int days = calculateDays(bookId, accountId);
		int fine = 0;
		if (type.equals("Data Analytics")) {
			fine = days * 5;
		} else if (type.equals("Technology")) {
			fine = days * 6;
		} else {
			fine = days * 7;
		}
		if (numBooks > 0) {
			bookIssueDao.addFine(bookId, accountId, fine);
			bookIssueDao.setReturned(bookId, accountId);
			return fine;
		}
		return -1;
	}

	@Override
	public ArrayList<BookIssue> listAllBooks(int accountId) {
		return bookIssueDao.listAllBooks(accountId);
//		return null;
	}

	@Override
	public int calculateDays(int bookId, int accountId) throws IssueDateGreaterException {
		BookIssue bookIssue=null;
		bookIssue= bookIssueDao.calculateDays(bookId, accountId);
		String issueDate = "", returnDate = "";
		issueDate = bookIssue.getIssueDate();
		returnDate = bookIssue.getReturnDate();
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
		return currentDate.getDayOfYear() - localReturnDate.getDayOfYear();
//		return 0;
	}

}
