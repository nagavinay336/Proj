package com.persistance;

import java.sql.SQLException;

import com.bean.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee emp);

	public boolean employeeExists(int empId) throws ClassNotFoundException, SQLException;
}
