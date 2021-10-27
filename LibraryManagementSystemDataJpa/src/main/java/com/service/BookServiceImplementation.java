package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Book;
import com.persistence.BookDao;

@Service
public class BookServiceImplementation implements BookService {

	@Autowired
	BookDao bookDao;

//	public BookServiceImplementation(BookDao bookDao) {
//		super();
//		this.bookDao = bookDao;
//	}

	@Override
	public void addBook(Book b) {
		bookDao.save(b);
	}

	@Override
	public ArrayList<Book> listAllBooks() {
		return (ArrayList<Book>) bookDao.findAll();
	}

	@Override
	public String getBookType(int bookId) {
		return bookDao.getBookType(bookId);
	}

	@Override
	public int numBookAvailable(int bookId) {
		return bookDao.numBookAvailable(bookId);
	}

	@Override
	public void decreaseNumBooksAvailable(int bookId) {
		bookDao.decreaseNumBooksAvailable(bookId);
	}

	@Override
	public void increaseNumBooksAvailable(int bookId) {
		bookDao.increaseNumBooksAvailable(bookId);
	}

}
