package com.sortingbooks;

public class BooksArray {
	private Books[] books;
	private int n;

	public void setN(int n) {
		this.n = n;
		books = new Books[n];
	}

	public int getN() {
		return n;
	}

	public Books[] getBooks() {
		return books;
	}

	public void setData(int ind, Books obj) {
		books[ind] = obj;
	}

	public Books[] sortNoOfPages(Books[] b) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (b[j].getNoOfPages() < b[min].getNoOfPages()) {
					min = j;
				}
			}
			Books temp = b[min];
			b[min]=b[i];
			b[i]=temp;
		}
		return b;
	}

	
	public Books[] sortNameDesc(Books[] b) {
		for (int i = 0; i < n - 1; i++) {
			int flag=0;
			for (int j = 0; j < n - i - 1; j++) {
				if ((b[j].getName()).compareTo(b[j + 1].getName())<0) {
					Books temp = b[j];
					b[j]=b[j + 1];
					b[j + 1]=temp;
					flag=1;
				}
			}
			if(flag==0) {
				break;
			}
		}
		return b;
	}
	public void display() {
		for (int i = 0; i < n; i++) {
			System.out.println("Book id: " + books[i].getId() + " Book Name: " + books[i].getName() + " Author: "
					+ books[i].getAuthor() + " Price: " + books[i].getPrice() + " No. of Pages: "
					+ books[i].getNoOfPages());
		}
	}
}
