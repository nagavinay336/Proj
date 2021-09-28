package com.employeecourses;

import java.util.ArrayList;

public class CourseCoordinator {
	private ArrayList<Course> courses;
	private int size;

	CourseCoordinator() {
		this.courses = null;
		this.size = 0;
	}

	public void setData(Course cOb) {
		this.courses.add(cOb);
	}

	public void setSize(int size) {
		this.size = size;
		courses = new ArrayList<Course>(this.size);
	}

	public void registerEmployees(String courseName, String empName) {
		boolean found = false;
		for (Course c : courses) {
			if (c.getName().equalsIgnoreCase(courseName)) {
				c.getEmployees().add(empName);
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("No such course available :(");
		else
			System.out.println("Employee registered :(");
	}

	public void listEmployees(String courseName) {
		boolean found = false;
		for (Course c : courses) {
			if (c.getName().equalsIgnoreCase(courseName)) {
				for (String empName : c.getEmployees())
					System.out.println(empName);
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("No such course available :(");
	}

	public void deregisterEmployee(String courseName, String empName) {
		boolean found = false;
		for (Course c : courses) {
			if (c.getName().equalsIgnoreCase(courseName)) {
				found = c.getEmployees().remove(empName);
				break;
			}
		}
		if (!found)
			System.out.println("No such record found :(");
		else
			System.out.println("Employee deregistered :)");
	}

	public void showCourseDetails(String courseName) {
		boolean found = false;
		for (Course c : courses) {
			if (c.getName().equalsIgnoreCase(courseName)) {
				System.out.println("Course name : " + c.getName());
				System.out.println("Course fees : " + c.getCourseFee());
				System.out.println("Course medium : " + c.getMedium());
				System.out.println("Course time : " + c.getCourseTime());
				System.out.println("Course employees : " + c.getEmployees());
				found = true;
			}
		}
		if (!found)
			System.out.println("No such course available :(");
	}

	public void showAllCoursesDetails() {
		for (Course c : courses) {
			System.out.println("Course name : " + c.getName());
			System.out.println("Course fees : " + c.getCourseFee());
			System.out.println("Course medium : " + c.getMedium());
			System.out.println("Course time : " + c.getCourseTime());
			System.out.println("Course employees : " + c.getEmployees());
			System.out.println("-----------------------------------------");
		}
	}
}
