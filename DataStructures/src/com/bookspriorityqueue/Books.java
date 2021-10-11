package com.bookspriorityqueue;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Books {

	private int bookId;
	private String name;
	private int price;
	private String authorName;
	private int noOfPages;
}
