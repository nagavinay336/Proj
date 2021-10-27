package com.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

//	public void addBook(Book b);

//	public ArrayList<Book> listAllBooks();

	@Query("select type from Book where bookId=:bookId")
	public String getBookType(@Param("bookId") int bookId);

	@Query("select numOfCopies from Book where bookId=:bookId")
	public int numBookAvailable(@Param("bookId") int bookId);

	@Transactional
	@Modifying
	@Query("update Book set numOfCopies=numOfCopies-1 where bookId=:bookId")
	public void decreaseNumBooksAvailable(@Param("bookId") int bookId);

	@Transactional
	@Modifying
	@Query("update Book set numOfCopies=numOfCopies-1 where bookId=:bookId")
	public void increaseNumBooksAvailable(@Param("bookId") int bookId);
}
