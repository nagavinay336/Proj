package com.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Employee;

public class EmployeeDaoImplementation implements EmployeeDao {

	@Override
	public void addEmployee(Employee emp) {

	}

	@Override
	public boolean employeeExists(int empId) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryDB", "root", "123456");

		PreparedStatement preparedStatement = connection.prepareStatement("Select * from employee where employee_id=?");
		preparedStatement.setInt(1, empId);
		ResultSet resultSet = preparedStatement.executeQuery();
		int emp = 0;
		while (resultSet.next()) {
			emp = resultSet.getInt("Employee_Id");
		}
		if (emp > 0) {
			return true;
		}
		return false;
	}

}
