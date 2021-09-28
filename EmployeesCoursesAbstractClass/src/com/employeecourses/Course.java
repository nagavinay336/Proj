package com.employeecourses;

import java.util.ArrayList;

public class Course {
	private String name;
	private float courseFee;
	private String medium;
	private String courseTime;
	private ArrayList<String> employees;
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		this.employees = new ArrayList<String>(this.size);
	}

	public ArrayList<String> getEmployees() {
		return this.employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(float courseFee) {
		this.courseFee = courseFee;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public void setEmployeesData(String name) {
		employees.add(name);
	}

}
