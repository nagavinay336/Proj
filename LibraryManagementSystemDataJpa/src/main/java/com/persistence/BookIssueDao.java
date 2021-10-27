package com.persistence;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.BookIssue;

@Repository
public interface BookIssueDao extends JpaRepository<BookIssue, Integer> {

//	public String issueBook(int bookId, int accountId, int numCopies)
//			throws NumOfBooksLimitExceededException, NoCopiesAvailableException;

//	public int returnBook(int bookId, int accountId) throws IssueDateGreaterException;

	@Query("select bi from BookIssue bi where accountId=:accountId and returnedStatus=false")
	public ArrayList<BookIssue> listAllBooks(@Param("accountId") int accountId);

	@Query("select bi from BookIssue bi where bookId=:bookId and accountId=:accountId and returnedStatus=false")
	public BookIssue calculateDays(@Param("bookId") int bookId, @Param("accountId") int accountId);

	@Transactional
	@Modifying
	@Query("update BookIssue set fineForBook=:fineForBook where bookId=:bookId and accountId=:accountId and returnedStatus=false")
	public void addFine(@Param("bookId") int bookId, @Param("accountId") int accountId, @Param("fineForBook") int fine);

	@Transactional
	@Modifying
	@Query("update BookIssue set returnedStatus=true where bookId=:bookId and accountId=:accountId and returnedStatus=false")
	public void setReturned(@Param("bookId") int bookId, @Param("accountId") int accountId);
}
