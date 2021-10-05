package com.sujata.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sujata.bean.Employee;
import com.sujata.service.EmployeeService;
import com.sujata.service.EmployeeServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService = new EmployeeServiceImpl();

	@Override
	public void showMenu() {
		System.out.println("1. List All Employees");
		System.out.println("2. Search Employee");
		System.out.println("3. Add Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Update Salary");
		System.out.println("6. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner sc = new Scanner(System.in);
		switch (choice) {
		case 1:
			try {
				ArrayList<Employee> employees = employeeService.getAllEmployees();
				for (Employee employee : employees) {
					System.out.println(employee);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;
		case 2:
			try {
				Employee emp = new Employee();
				System.out.println("You have selected searching employee by Id.\nEnter the employee id");
				int empId = sc.nextInt();
				emp = employeeService.searchEmployee(empId);
				System.out.println(emp);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				Employee emp = new Employee();
				System.out.println("You have selected Insertion: \nEnter the id of the employee: ");
				emp.setEmpId(sc.nextInt());
				System.out.println("Enter the name of employee: ");
				emp.setEmpName(sc.next());
				System.out.println("Enter the department of the employee: ");
				emp.setEmpDepartment(sc.next());
				System.out.println("Enter the designation of the employee: ");
				emp.setEmpDesignation(sc.next());
				System.out.println("Enter the salary of the employee: ");
				emp.setEmpSalary(sc.nextInt());
				employeeService.insertEmployee(emp);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;
		case 4:
			try {
				System.out.println("You have selected Deletion of Employee using ID: \nEnter the id of the employee: ");
				int empId = sc.nextInt();
				employeeService.deleteEmployee(empId);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			break;
		case 5:
			try {
				System.out.println(
						"You have selected Updation of Employee salary using ID: \nEnter the id of the employee: ");
				int empId = sc.nextInt();
				System.out.println("Enter the salary of the employee: ");
				int salary = sc.nextInt();
				employeeService.updateSalary(empId, salary);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case 6:
			System.out.println("Thanks for using Employee Management System");
			System.exit(0);
		default:
			break;
		}

	}

}
