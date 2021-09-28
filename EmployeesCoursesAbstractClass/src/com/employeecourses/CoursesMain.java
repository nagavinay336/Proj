package com.employeecourses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoursesMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size;
		int i;
		int j;
		CourseCoordinator ob = new CourseCoordinator();
		System.out.println("Enter the number of courses : ");
		size = Integer.parseInt(br.readLine());
		ob.setSize(size);
		for(i = 0; i < size; i ++)
		{
			Course cOb = new Course();
			System.out.println("Enter the course name : ");
			cOb.setName(br.readLine());
			System.out.println("Enter the course fees : ");
			cOb.setCourseFee(Float.parseFloat(br.readLine()));
			System.out.println("Enter the course medium (classroom / online) : ");
			cOb.setMedium(br.readLine());
			System.out.println("Enter the course time(full time / part time) : ");
			cOb.setCourseTime(br.readLine());
			System.out.println("Enter the number of employees enrolled : ");
			cOb.setSize(Integer.parseInt(br.readLine()));
			if(cOb.getSize() == 0)
				continue;
			System.out.println("Enter the employees' name : ");
			for(j = 0; j < cOb.getSize(); j ++)
			{
				cOb.getEmployees().add(br.readLine());
			}
			ob.setData(cOb);
		}
		int ch;
		do
		{
			System.out.println("1. Register an employee.");
			System.out.println("2. Print employees for a course.");
			System.out.println("3. Deregister an employee.");
			System.out.println("4. Details for a course.");
			System.out.println("5. Details for all courses.");
			System.out.println("6. Exit.");
			System.out.println("Enter your choice : ");
			ch = Integer.parseInt(br.readLine());
			System.out.println();
			if(ch == 1)
			{
				System.out.println("Enter the course name and employee name : ");
				String courseName = br.readLine();
				String empName = br.readLine();
				ob.registerEmployees(courseName, empName);
			}
			else if(ch == 2)
			{
				System.out.println("Enter the course name : ");
				String courseName = br.readLine();
				ob.listEmployees(courseName);
			}
			else if(ch == 3)
			{
				System.out.println("Enter the course name and employee name : ");
				String courseName = br.readLine();
				String empName = br.readLine();
				ob.deregisterEmployee(courseName, empName);
			}
			else if(ch == 4)
			{
				System.out.println("Enter the course name : ");
				String courseName = br.readLine();
				ob.showCourseDetails(courseName);
			}
			else if(ch == 5)
			{
				ob.showAllCoursesDetails();
			}
			else if(ch == 6)
				System.out.println("Exiting...");
			else 
				System.out.println("Invalid Choice. Renter!");
		}while(ch != 6);
	}

}
