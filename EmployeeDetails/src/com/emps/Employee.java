package com.emps;

public class Employee {
	private String empName, empdesgn, empLoc;
	private int empId, empAge, empExp;

	@Override
	public String toString() {
		return " [empName=" + empName + ", empdesgn=" + empdesgn + ", empLoc=" + empLoc + ", empId=" + empId
				+ ", empAge=" + empAge + ", empExp=" + empExp + "]";
	}

	public Employee(String empName) {
		super();
		this.empName = empName;
	}

	public Employee(String empName, int empId) {
		super();
		this.empName = empName;
		this.empId = empId;
	}

	public Employee(String empName, int empId, int empAge) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
	}

	public Employee(String empName, String empdesgn, int empId) {
		super();
		this.empName = empName;
		this.empdesgn = empdesgn;
		this.empId = empId;
	}

	public Employee(String empName, String empdesgn, int empId, int empAge) {
		super();
		this.empName = empName;
		this.empdesgn = empdesgn;
		this.empId = empId;
		this.empAge = empAge;
	}

	public Employee(String empName, int empId, int empAge, String empLoc) {
		super();
		this.empName = empName;
		this.empLoc = empLoc;
		this.empId = empId;
		this.empAge = empAge;
	}

	public Employee(String empName, int empId, int empAge, int empExp) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
		this.empExp = empExp;
	}

	public Employee(String empName, String empdesgn, String empLoc, int empId, int empExp) {
		super();
		this.empName = empName;
		this.empdesgn = empdesgn;
		this.empLoc = empLoc;
		this.empId = empId;
		this.empExp = empExp;
	}

	public Employee(String empName, String empdesgn, String empLoc, int empId, int empAge, int empExp) {
		super();
		this.empName = empName;
		this.empdesgn = empdesgn;
		this.empLoc = empLoc;
		this.empId = empId;
		this.empAge = empAge;
		this.empExp = empExp;
	}
}
