package com.persistence;
//package com.persistance;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.bean.Employee;
//import com.helper.EmployeeRowMapper;
//
//@Component
//public class EmployeeDaoImplementation implements EmployeeDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public void addEmployee(Employee emp) {
//
//	}
//
//	@Override
//	public boolean employeeExists(int empId) throws EmptyResultDataAccessException {
//
//		Integer emp;
//		String query = "Select employee_id from employee where employee_id=?";
//		emp = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), empId);
//		if (emp > 0) {
//			return true;
//		}
//		return false;
//	}
//
//}
