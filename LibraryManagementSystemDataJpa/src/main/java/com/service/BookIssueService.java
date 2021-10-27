package com.service;

import java.util.ArrayList;

import com.bean.BookIssue;
import com.exceptions.IssueDateGreaterException;
import com.exceptions.NoBooksWithEmployee;
import com.exceptions.NoCopiesAvailableException;
import com.exceptions.NumOfBooksLimitExceededException;

public interface BookIssueService {

	public String issueBook(int bookId, int accountId, int numBooks, int numCopies)
			throws NumOfBooksLimitExceededException, NoCopiesAvailableException;

	public int returnBook(int bookId, int accountId, String type, int numBooks) throws IssueDateGreaterException;

	public ArrayList<BookIssue> listAllBooks(int accountId) throws NoBooksWithEmployee;

	public int calculateDays(int bookId, int accountId) throws IssueDateGreaterException;

}
