package com.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Book;

public interface BookDao {

	public void addBook(Book b);

	public ArrayList<Book> listAllBooks() throws SQLException,ClassNotFoundException;
}
