package com.sortingbooks;

public class Books {
	private int id, noOfPages;
	private String name, author;

	public Books(int id, int noOfPages, String name, String author, double price) {
		super();
		this.id = id;
		this.noOfPages = noOfPages;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	private double price;
}
