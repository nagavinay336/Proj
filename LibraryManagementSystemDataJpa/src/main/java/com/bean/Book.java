package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	@Id
	private int bookId;
	private int numOfCopies;
	private String bookName, authorName;
	private String type;
}
