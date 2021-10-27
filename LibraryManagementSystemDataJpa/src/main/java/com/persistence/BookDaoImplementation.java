package com.persistence;
//package com.persistance;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.bean.Book;
//import com.helper.BookRowMapper;
//
//@Component
//public class BookDaoImplementation implements BookDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public void addBook(Book b) {
//
//	}
//
//	@Override
//	public ArrayList<Book> listAllBooks() {
//		List<Book> books;
//		String query = "Select * from book";
//		books = jdbcTemplate.query(query, new BookRowMapper());
//		return (ArrayList<Book>) books;
//	}
//
//	public String getBookType(int bookId) {
//
//		Book book;
//		String query = "SELECT * FROM BOOK where BOOK_ID= ? ";
//		book = jdbcTemplate.queryForObject(query, new BookRowMapper(), bookId);
//		String type = "";
//		type = book.getType();
//		return type;
//	}
//
//	public int numBookAvailable(int bookId) {
//
//		Book book;
//		String query = "Select * from book where book_id=?";
//		book = jdbcTemplate.queryForObject(query, new BookRowMapper(), bookId);
//		if (book != null) {
//			int numCopies = book.getNumOfCopies();
//			return numCopies;
//		}
//		return 0;
//	}
//
//	public void decreaseNumBooksAvailable(int numCopies, int bookId) {
//
//		String query = "update book set NUM_OF_COPIES= ? where book_id= ? ";
//		jdbcTemplate.update(query, numCopies - 1, bookId);
//	}
//
//	public void increaseNumBooksAvailable(int numCopies, int bookId) {
//
//		String query = "update book set NUM_OF_COPIES= ? where book_id= ? ";
//		jdbcTemplate.update(query, numCopies + 1, bookId);
//	}
//}
