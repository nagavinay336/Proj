package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bean.EmployeeAccount;
import com.exceptions.AccountAlreadyExists;
import com.persistence.EmployeeAccountDao;

@Service
public class EmployeeAccountServiceImplementation implements EmployeeAccountService {

	@Autowired
	EmployeeAccountDao employeeAccountDao;

//	public EmployeeAccountServiceImplementation(EmployeeAccountDao employeeAccountDao) {
//		this.employeeAccountDao = employeeAccountDao;
//	}

	@Override
	public Optional<EmployeeAccount> getEmployeeAccountDetail(int accountId) {
		return employeeAccountDao.findById(accountId);
//		return null;
	}

	@Override
	public boolean deleteEmployeeAccount(int accountID) {
		return employeeAccountDao.deleteEmployeeAccount(accountID);
	}

	@Override
	public boolean createEmployeeAccount(EmployeeAccount empAcc){
		EmployeeAccount employeeAccount= employeeAccountDao.save(empAcc);
		if(employeeAccount!=null) {
			return true; 			
		}
		return false;
	}

	@Override
	public boolean accountExists(int accountId) throws EmptyResultDataAccessException {
		int accId= employeeAccountDao.accountExists(accountId);
		if(accId>0) {
			return true;
		}
		return false;
	}

	@Override
	public int numOfBooksIssued(int accountId) {
		return employeeAccountDao.numOfBooksIssued(accountId);
	}

	@Override
	public void decreaseNumBooksIssued(int accountId) {
		employeeAccountDao.decreaseNumBooksIssued(accountId);
	}

	@Override
	public void increaseNumBooksIssued(int accountId) {
		employeeAccountDao.increaseNumBooksIssued(accountId);
	}

	@Override
	public boolean employeeExists(int empId) throws EmptyResultDataAccessException {
		return employeeAccountDao.employeeExists(empId);
	}

}
