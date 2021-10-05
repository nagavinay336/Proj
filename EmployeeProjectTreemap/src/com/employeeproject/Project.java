package com.employeeproject;

import lombok.Data;

@Data
public class Project {

	private int pId;
	private String pName;

	public Project(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}
}
