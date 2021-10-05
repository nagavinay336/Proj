package com.sujata.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.sujata.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public ArrayList<Employee> getAllRecords() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EmployeeDB2", "root",
				"123456");

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Employee> employees = new ArrayList<Employee>();
		// 3.Process Result
		while (resultSet.next()) {
			int empId = resultSet.getInt("ID");
			String na = resultSet.getString("NAME");
			String deptt = resultSet.getString("DEPARTMENT");
			String desig = resultSet.getString("DESIGNATION");
			int sal = resultSet.getInt("SALARY");
			Employee employee = new Employee(empId, na, deptt, desig, sal);
			employees.add(employee);
		}
		connection.close();
		return employees;
	}

	@Override
	public boolean insertData(Employee employee) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		PreparedStatement preparedStatement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EmployeeDB2", "root",
				"123456");

		// 2.Query
		preparedStatement = connection
				.prepareStatement("INSERT INTO EMPLOYEE(ID,NAME,DEPARTMENT,DESIGNATION,SALARY) VALUES(?,?,?,?,?)");

		preparedStatement.setInt(1, employee.getEmpId());
		preparedStatement.setString(2, employee.getEmpName());
		preparedStatement.setString(3, employee.getEmpDepartment());
		preparedStatement.setString(4, employee.getEmpDesignation());
		preparedStatement.setInt(5, employee.getEmpSalary());

		int rows = preparedStatement.executeUpdate();

		// 3.Process Result
		if (rows > 0) {
			System.out.println("Employee added succesfully!");
			return true;
		} else {
			System.out.println("Employee added failed!");
			return false;
		}
	}

	@Override
	public boolean deleteData(int empId) throws ClassNotFoundException, SQLException {
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EmployeeDB2", "root",
				"123456");
		statement = connection.createStatement();
		int rows = statement.executeUpdate("Delete from employee where id=" + empId);
		if (rows > 0) {
			System.out.println("Employee deleted succesfully!");
			return true;
		} else {
			System.out.println("Employee deletion failed!");
			return false;
		}
	}

	@Override
	public boolean updateSalary(int empId, int salary) throws ClassNotFoundException, SQLException {
		Statement statement = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EmployeeDB2", "root",
				"123456");
		statement = connection.createStatement();
		int rows = statement.executeUpdate("update employee set salary=" + salary + " where id=" + empId);
		if (rows > 0) {
			System.out.println("Employee updated succesfully!");
			return true;
		} else {
			System.out.println("Employee update failed!");
			return false;
		}
	}

	@Override
	public Employee searchRecord(int empId) throws ClassNotFoundException, SQLException {
		Statement statement = null;
		Employee employee=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EmployeeDB2", "root",
				"123456");
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee where id=" + empId);
		while (resultSet.next()) {
			String na = resultSet.getString("NAME");
			String deptt = resultSet.getString("DEPARTMENT");
			String desig = resultSet.getString("DESIGNATION");
			int sal = resultSet.getInt("SALARY");
			employee = new Employee(empId, na, deptt, desig, sal);
		}
		connection.close();
		return employee;
	}

}
