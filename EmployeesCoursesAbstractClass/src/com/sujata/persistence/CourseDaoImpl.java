package com.sujata.persistence;

import com.sujata.beans.Course;
import com.sujata.beans.Employee;
import com.sujata.database.CourseDataBase;

public class CourseDaoImpl implements CourseDao {

	@Override
	public Course[] getAllCourses() {
		return CourseDataBase.getCourses();
	}

	@Override
	public Course searchCourseById(String cId) {
		for (Course course : CourseDataBase.getCourses()) {
			if (course.getCourseId().equals(cId))
				return course;
		}
		return null;
	}

	@Override
	public boolean addEmployeeForCourseId(String cID, Employee employee) {
		int index = 0;
		Course[] courses = CourseDataBase.getCourses();
		for (Course course : courses) {
			if (course.getCourseId().equals(cID)) {
				Employee[] employees = courses[index].getEmployees();
				
				if(Course.getEmpCount()==10) {
					throw new CourseRegistrationFullException("Course Registration Full");
				}
				employees[Course.getEmpCount()] = employee;
				courses[index].setEmployees(employees);

				int count = Course.getEmpCount();
				Course.setEmpCount(count + 1);

				return true;
			}
			index++;
		}
		return false;
	}

	@Override
	public boolean removeEmployeeFromCourse(String cId, int empId) {
		int ind=0;
		Course[] courses = CourseDataBase.getCourses();
		for (Course course : courses) {
			if (course.getCourseId().equals(cId)) {
				int j = 0;
				Employee[] employees = course.getEmployees();
				if(Course.getEmpCount()==0) {
					return false;
				}
				for (Employee emp : employees) {
					if (emp.getEmpId() == empId) {
						ind=j;
						break;
					}
					j++;
				}
				
				for(j=ind;j<Course.getEmpCount()-1;j++) {
					course.setEmployee(j,course.getEmployee(j+1));				
				}
				course.setEmployee(Course.getEmpCount()-1,null);
				return true;
			}
		}
		return false;
	}

}
