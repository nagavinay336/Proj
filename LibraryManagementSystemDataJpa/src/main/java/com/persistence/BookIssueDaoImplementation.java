package com.persistence;
//package com.persistance;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.bean.BookIssue;
//import com.exceptions.IssueDateGreaterException;
//import com.exceptions.NoCopiesAvailableException;
//import com.exceptions.NumOfBooksLimitExceededException;
//import com.helper.BookIssueRowMapper;
//
//@Component
//public class BookIssueDaoImplementation implements BookIssueDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public String issueBook(int bookId, int accountId, int numCopies)
//			throws NumOfBooksLimitExceededException, NoCopiesAvailableException {
//
//		LocalDate currentDate = LocalDate.now();
//		LocalDate d1 = currentDate.plusDays(7);
//		String query = "Insert into Books_issue values(?,?,?,?,?,?)";
//		int rows = jdbcTemplate.update(query, bookId, accountId, currentDate.toString(), d1.toString(), 0, false);
//		if (rows > 0) {
//			return d1.toString();
//		}
//		return "";
//
//	}
//
//	@Override
//	public int returnBook(int bookId, int accountId) throws IssueDateGreaterException {
//		return 0;
//	}
//
//	public void setReturned(int bookId, int accountId) {
//
//		String query = "update books_issue set Returned_status= ? where book_id= ? and account_id= ? and returned_status= ? ";
//		jdbcTemplate.update(query, true, bookId, accountId, false);
//
//	}
//
//	public void addFine(int bookId, int accountId, int fine) {
//
//		String query = "update books_issue set FINE_FOR_BOOK= ? where book_id= ? and account_id= ? and returned_status=false";
//		jdbcTemplate.update(query, fine, bookId, accountId);
//	}
//
//	public ArrayList<BookIssue> listAllBooks(int accountId) {
//// Handle this 
////		if (resultSet.getFetchSize() > 0) {
////			throw new NoBooksWithEmployee("You don't have any books with you");
////		}
//		List<BookIssue> bookIssue;
//		String query = "SELECT * FROM BOOKS_ISSUE where ACCOUNT_ID= ? and returned_status= ? ";
//		bookIssue = jdbcTemplate.query(query, new BookIssueRowMapper(), accountId, false);
//		return (ArrayList<BookIssue>) bookIssue;
//	}
//
//	public int calculateDays(int bookId, int accountId) throws IssueDateGreaterException {
//
//		BookIssue bookIssue;
//		String query = "SELECT * FROM BOOKS_ISSUE where BOOK_ID= ? and Account_id= ? and returned_status= ? ";
//		bookIssue = jdbcTemplate.queryForObject(query, new BookIssueRowMapper(), bookId, accountId, false);
//		String issueDate = "", returnDate = "";
//		issueDate = bookIssue.getIssueDate();
//		returnDate = bookIssue.getReturnDate();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate localIssueDate = LocalDate.parse(issueDate, formatter);
//		LocalDate localReturnDate = LocalDate.parse(returnDate, formatter);
//		LocalDate currentDate = LocalDate.now();
//		if (localIssueDate.isAfter(currentDate)) {
//			throw new IssueDateGreaterException("Issue date is greater then the current date.");
//		}
//		if (localReturnDate.isAfter(currentDate) || localReturnDate.equals(currentDate)) {
//			// fine is 0 because the book was returned early or on time
//			return 0;
//		}
//		return currentDate.getDayOfYear() - localReturnDate.getDayOfYear();
//	}
//
//}
