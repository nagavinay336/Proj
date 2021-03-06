package com.sujata.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sujata.bean.Employee;

public interface EmployeeDao {

	ArrayList<Employee> getAllRecords() throws ClassNotFoundException, SQLException;

	boolean insertData(Employee employee) throws ClassNotFoundException, SQLException;

	boolean deleteData(int empId) throws ClassNotFoundException, SQLException;

	boolean updateSalary(int empId, int salary) throws ClassNotFoundException, SQLException;

	Employee searchRecord(int empId) throws ClassNotFoundException, SQLException;
}
