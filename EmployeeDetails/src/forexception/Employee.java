package com.forexception;

import java.util.Scanner;

public class Employee extends Exception {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name[]=new String[20];
		int age[]=new int[20];
		int choice;
		int i=0;
		while(true) {
			System.out.println("Enter: \n1. To add new Employee \n2. To Exit");
			choice=sc.nextInt();
			if(choice!=1) {
				break;
			}
			System.out.println("Enter the name of the employee");
			String na=sc.next();
			if(i==0) {
				System.out.println("Enter the age of the employee");
				int a=sc.nextInt();
				try {
					validateAge(a);
				} catch (InappropriateAgeException e) {
					System.out.println("Exception occoured "+e.getMessage());
					continue;
				}
				name[i]=na;
				age[i]=a;
			}
			else {
				try {
					validateName(na,name,i);
				} catch (EmployeeAlreadyExistsException e) {
					System.out.println("Exception occoured "+e.getMessage());
					continue;
				}
				System.out.println("Enter the age of the employee");
				int a=sc.nextInt();
				try {
					validateAge(a);
				} catch (InappropriateAgeException e) {
					System.out.println("Exception occoured "+e.getMessage());
					continue;
				}
				name[i]=na;
				age[i]=a;
			}
			System.out.println("Employee Added Successfully");
			i++;
		}
	}
	static void validateAge(int a) throws InappropriateAgeException {
		if(a<18 || a>60) {
			throw new InappropriateAgeException("Inappropriate Age");
		}
	}
	static void validateName(String na,String name[],int i) throws EmployeeAlreadyExistsException {
		for(int j=0;j<i;j++) {
			if(name[j].equals(na)) {
				throw new EmployeeAlreadyExistsException("Employee Exists");
			}
		}
	}
}
