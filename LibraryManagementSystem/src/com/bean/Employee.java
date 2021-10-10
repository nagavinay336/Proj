package com.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int employeeId, libraryId;
	private String employeeName;
	private int employeePhone;
	private String address;
}
