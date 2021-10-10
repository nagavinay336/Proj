package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Book;

public interface BookService {

	public void addBook(Book b)  throws ClassNotFoundException, SQLException ;

	public ArrayList<Book> listAllBooks()  throws ClassNotFoundException, SQLException ;
}
