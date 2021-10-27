package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.persistence.EmployeeDao;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

//	EmployeeServiceImplementation(EmployeeDao employeeDao) {
//		super();
//		this.employeeDao = employeeDao;
//	}

	@Override
	public void addEmployee(Employee emp) {
		employeeDao.save(emp);
	}

	@Override
	public boolean employeeExists(int empId) throws EmptyResultDataAccessException {
		int employeeId= employeeDao.employeeExists(empId);
		if(employeeId>0) {
			return true;
		}
		return false;
	}

}
