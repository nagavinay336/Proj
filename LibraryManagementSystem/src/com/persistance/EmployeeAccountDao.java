package com.persistance;

import java.sql.SQLException;

import com.bean.EmployeeAccount;
import com.exceptions.AccountAlreadyExists;

public interface EmployeeAccountDao {

	EmployeeAccount getEmployeeAccountDetails(int accountId) throws ClassNotFoundException, SQLException;

	boolean deleteEmployeeAccount(int accountID) throws ClassNotFoundException, SQLException;

	boolean createEmployeeAccount(EmployeeAccount empAcc)
			throws ClassNotFoundException, SQLException, AccountAlreadyExists;

	boolean accountExists(int accountId) throws ClassNotFoundException, SQLException;

}
