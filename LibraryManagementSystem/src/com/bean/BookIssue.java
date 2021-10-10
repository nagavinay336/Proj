package com.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookIssue {

	private int bookId, accountId, fineForBook, numBooksIssued;
	private String issueDate, returnDate;
	private boolean returnedStatus;
}
