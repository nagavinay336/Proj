package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Book;
import com.persistance.BookDao;
import com.persistance.BookDaoImplementation;

public class BookServiceImplementation implements BookService{

	BookDao bookDao=new BookDaoImplementation();
	@Override
	public void addBook(Book b)  throws ClassNotFoundException, SQLException {
		
	}

	@Override
	public ArrayList<Book> listAllBooks() throws ClassNotFoundException, SQLException {
		return bookDao.listAllBooks();
	}

}
