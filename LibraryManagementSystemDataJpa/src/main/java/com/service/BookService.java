package com.service;

import java.util.ArrayList;

import com.bean.Book;

public interface BookService {

	public void addBook(Book b);

	public ArrayList<Book> listAllBooks();

	public String getBookType(int bookId);

	public int numBookAvailable(int bookId);

	public void decreaseNumBooksAvailable(int bookId);

	public void increaseNumBooksAvailable(int bookId);
}
