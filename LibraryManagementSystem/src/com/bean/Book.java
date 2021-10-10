package com.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {

	private int bookId, numOfCopies;
	private String bookName, authorName;
	private String type;
}
