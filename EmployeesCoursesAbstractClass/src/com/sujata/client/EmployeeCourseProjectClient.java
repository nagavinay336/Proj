package com.sujata.client;

import java.util.Scanner;

import com.sujata.persistence.CourseRegistrationFullException;
import com.sujata.presentation.EmployeePresentation;
import com.sujata.presentation.EmployeePresentationImpl;

public class EmployeeCourseProjectClient{

	public static void main(String args[]) {
		EmployeePresentation employeePresentation = new EmployeePresentationImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice = sc.nextInt();
			try {
				employeePresentation.performMenu(choice);						
			}
			catch(CourseRegistrationFullException e) {
				System.out.println(" Exception Encountered!! "+e.getMessage()+"\n \n");
			}
		}
		
	}

}
