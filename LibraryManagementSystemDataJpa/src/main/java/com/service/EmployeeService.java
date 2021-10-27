package com.service;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bean.Employee;

public interface EmployeeService {

	public void addEmployee(Employee emp);

	public boolean employeeExists(int empId) throws EmptyResultDataAccessException;
}
