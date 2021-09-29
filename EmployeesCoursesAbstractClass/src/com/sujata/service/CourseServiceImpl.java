package com.sujata.service;

import com.sujata.beans.Course;
import com.sujata.beans.Employee;
import com.sujata.persistence.CourseDao;
import com.sujata.persistence.CourseDaoImpl;

public class CourseServiceImpl implements CourseService {

	private CourseDao courseDao = new CourseDaoImpl();

	@Override
	public Course[] getAllCoursesForEmployee() {

		return courseDao.getAllCourses();
	}

	@Override
	public boolean registerEmployeeForCourse(String cId, Employee employee) {
		return courseDao.addEmployeeForCourseId(cId, employee);
	}

	@Override
	public boolean deregisterEmployeeForCourse(String cId,int empId) {
		return courseDao.removeEmployeeFromCourse(cId, empId);
	}

	@Override
	public Employee[] listOfEmployeesForCourse(String cID) {

		return courseDao.searchCourseById(cID).getEmployees();
	}

}
