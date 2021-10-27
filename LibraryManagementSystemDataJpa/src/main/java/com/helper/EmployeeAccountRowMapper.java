package com.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bean.EmployeeAccount;

public class EmployeeAccountRowMapper implements RowMapper<EmployeeAccount> {

	@Override
	public EmployeeAccount mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int accountId = resultSet.getInt("LIBRARY_ACC_ID");
		int numOfBooks = resultSet.getInt("NUM_OF_BOOKS_WITH_EMPLOYEE");
		int empId = resultSet.getInt("EMPLOYEE_ID");
		EmployeeAccount employeeAccount = new EmployeeAccount(accountId, numOfBooks, empId);
		return employeeAccount;
	}

}
