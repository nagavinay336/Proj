package com.service;

import java.sql.SQLException;

import com.bean.Employee;

public interface EmployeeService {

	public void addEmployee(Employee emp);

	public boolean employeeExists(int empId) throws ClassNotFoundException, SQLException;
}
