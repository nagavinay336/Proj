package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeAccount {

	@Id
	private int accountId;
	private int numOfBooks, employeeId;
}
