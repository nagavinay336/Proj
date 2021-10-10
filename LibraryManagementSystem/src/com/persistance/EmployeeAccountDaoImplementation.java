package com.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.EmployeeAccount;
import com.exceptions.AccountAlreadyExists;

public class EmployeeAccountDaoImplementation implements EmployeeAccountDao {

	@Override
	public EmployeeAccount getEmployeeAccountDetails(int accountId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection
				.prepareStatement("Select * from Employee_Account where LIBRARY_ACC_ID= ? ");
		preparedStatement.setInt(1, accountId);
		ResultSet resultSet = preparedStatement.executeQuery();
		EmployeeAccount acc = null;
		while (resultSet.next()) {
			int numOfBooks = resultSet.getInt("NUM_OF_BOOKS_WITH_EMPLOYEE");
			int employeeId = resultSet.getInt("Employee_id");

			acc = new EmployeeAccount(accountId, numOfBooks, employeeId);
		}
		return acc;
	}

	@Override
	public boolean deleteEmployeeAccount(int accountID) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");
		PreparedStatement preparedStatement;
		boolean res = accountExists(accountID);
		int success = 0;

		if (!res) {
			preparedStatement = connection.prepareStatement("delete from employee_account where LIBRARY_ACC_ID= ? ");
			preparedStatement.setInt(1, accountID);
			success = preparedStatement.executeUpdate();
			if (success > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean createEmployeeAccount(EmployeeAccount empAcc)
			throws ClassNotFoundException, SQLException, AccountAlreadyExists {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");
		PreparedStatement preparedStatement;
		boolean res = accountExists(empAcc.getAccountId());
		int success = 0;
		if (res) {
			throw new AccountAlreadyExists("Your account already exists. You can't create a new account");
		}

		if (!res) {
			preparedStatement = connection.prepareStatement("Insert into employee_Account values(?,?,?)");
			preparedStatement.setInt(1, empAcc.getAccountId());
			preparedStatement.setInt(2, empAcc.getNumOfBooks());
			preparedStatement.setInt(3, empAcc.getEmployeeId());
			success = preparedStatement.executeUpdate();
			if (success > 0) {
				return true;
			}
		}
		return false;
	}

	public boolean accountExists(int accountId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");
		PreparedStatement preparedStatement = connection
				.prepareStatement("Select * from Employee_account where LIBRARY_ACC_id= ? ");
		preparedStatement.setInt(1, accountId);
		ResultSet resultSet = preparedStatement.executeQuery();
		accountId = 0;
		while (resultSet.next()) {
			accountId = resultSet.getInt("LIBRARY_ACC_ID");
		}
		if (accountId != 0) {
			return true;
		}
		return false;
	}

}
