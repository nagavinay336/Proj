package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookIssue {

	@Id
	private int bookId;
	private int accountId, fineForBook;
	private String issueDate, returnDate;
	private boolean returnedStatus;
}
