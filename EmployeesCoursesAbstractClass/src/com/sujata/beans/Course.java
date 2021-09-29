package com.sujata.beans;

public class Course {

	private String courseId;
	private String courseName;
	private int courseFee;
	private boolean online;
	private boolean fullTime;
	private static int empCount;
	private Employee[] employees = new Employee[10];

	public Course() {

	}

	public Course(String courseId, String courseName, int courseFee, boolean online, boolean fullTime) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.online = online;
		this.fullTime = fullTime;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public Employee getEmployee(int ind) {
		return employees[ind];
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public void setEmployee(int ind,Employee employee) {
		this.employees[ind] = employee;
	}

	public static int getEmpCount() {
		return empCount;
	}

	public static void setEmpCount(int empCount) {
		Course.empCount = empCount;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee + ", online="
				+ online + ", fullTime=" + fullTime + "]";
	}

}
