package com.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

//	public void addEmployee(Employee emp);

	@Query("select employeeId from Employee where employeeId=:empId")
	public int employeeExists(@Param("empId") int empId) throws EmptyResultDataAccessException;
}
