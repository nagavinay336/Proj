package com.service;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bean.EmployeeAccount;
import com.exceptions.AccountAlreadyExists;

public interface EmployeeAccountService {

	Optional<EmployeeAccount> getEmployeeAccountDetail(int accountId);

	boolean deleteEmployeeAccount(int accountID);

	boolean createEmployeeAccount(EmployeeAccount empAcc);

	boolean accountExists(int accountId) throws EmptyResultDataAccessException;

	public boolean employeeExists(int empId) throws EmptyResultDataAccessException;

	public int numOfBooksIssued(int accountId);

	public void decreaseNumBooksIssued(int accountId);

	public void increaseNumBooksIssued(int accountId);
}
