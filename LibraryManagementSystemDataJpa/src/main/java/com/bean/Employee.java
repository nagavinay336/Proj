package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private int employeePhone;
	private String address;
}
