package com.emps;

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of Employee: ");
		String name = sc.next();
		Employee e1 = new Employee(name);
		System.out.println("Enter the employee id: ");
		int id = sc.nextInt();
		Employee e2 = new Employee(name, id);
		System.out.println("Ente the age of employee: ");
		int age = sc.nextInt();
		Employee e3 = new Employee(name, id, age);
		System.out.println("Enter employee Designation: ");
		String desig = sc.next();
		Employee e4 = new Employee(name, desig, id);
		Employee e5 = new Employee(name, desig, id, age);
		System.out.println("Enter employees location: ");
		String loc = sc.next();
		Employee e6 = new Employee(name, id, age, loc);
		System.out.println("Enter the experience of the Employee: ");
		int exp = sc.nextInt();
		Employee e7 = new Employee(name, id, age, exp);
		Employee e8 = new Employee(name, desig, loc, id, exp);
		Employee e9 = new Employee(name, desig, loc, id, age, exp);
		System.out.println("Employee1 "+e1.toString());
		System.out.println("Employee2 "+e2.toString());
		System.out.println("Employee3 "+e3.toString());
		System.out.println("Employee4 "+e4.toString());
		System.out.println("Employee5 "+e5.toString());
		System.out.println("Employee6 "+e6.toString());
		System.out.println("Employee7 "+e7.toString());
		System.out.println("Employee8 "+e8.toString());
		System.out.println("Employee9 "+e9.toString());
		
	}

}
