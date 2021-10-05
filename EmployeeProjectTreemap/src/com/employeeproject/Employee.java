package com.employeeproject;

import lombok.Data;

@Data
public class Employee implements Comparable<Employee>{

	
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}

	private int empId;
	private String name;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public int compareTo(Employee emp) {
		if(empId>emp.empId) {
			return 1;
		}
		else if(empId<emp.empId) {
			return -1;
		}
		return 0;
	}
}
