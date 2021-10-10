package com.service;

import java.sql.SQLException;

import com.bean.EmployeeAccount;
import com.exceptions.AccountAlreadyExists;
import com.persistance.EmployeeAccountDao;
import com.persistance.EmployeeAccountDaoImplementation;

public class EmployeeAccountServiceImplementation implements EmployeeAccountService {
	EmployeeAccountDao employeeAccountDao = new EmployeeAccountDaoImplementation();

	@Override
	public EmployeeAccount getEmployeeAccountDetail(int accountId) throws ClassNotFoundException, SQLException {
		return employeeAccountDao.getEmployeeAccountDetails(accountId);
	}

	@Override
	public boolean deleteEmployeeAccount(int accountID) throws ClassNotFoundException, SQLException {
		return employeeAccountDao.deleteEmployeeAccount(accountID);
	}

	@Override
	public boolean createEmployeeAccount(EmployeeAccount empAcc)
			throws ClassNotFoundException, SQLException, AccountAlreadyExists {
		return employeeAccountDao.createEmployeeAccount(empAcc);
	}

	@Override
	public boolean accountExists(int accountId) throws ClassNotFoundException, SQLException {
		return employeeAccountDao.accountExists(accountId);
	}

}
