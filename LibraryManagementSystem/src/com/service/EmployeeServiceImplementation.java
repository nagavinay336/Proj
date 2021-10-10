package com.service;

import java.sql.SQLException;

import com.bean.Employee;
import com.persistance.EmployeeDao;
import com.persistance.EmployeeDaoImplementation;

public class EmployeeServiceImplementation implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImplementation();

	@Override
	public void addEmployee(Employee emp) {

	}

	@Override
	public boolean employeeExists(int empId) throws ClassNotFoundException, SQLException {
		return employeeDao.employeeExists(empId);
	}

}
