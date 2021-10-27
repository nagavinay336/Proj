package com.persistence;
//package com.persistance;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.bean.EmployeeAccount;
//import com.exceptions.AccountAlreadyExists;
//import com.helper.EmployeeAccountRowMapper;
//
//@Component
//public class EmployeeAccountDaoImplementation implements EmployeeAccountDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public EmployeeAccount getEmployeeAccountDetails(int accountId) {
//
//		EmployeeAccount employeeAccount;
//		String query = "Select * from Employee_Account where LIBRARY_ACC_ID= ? ";
//		employeeAccount = jdbcTemplate.queryForObject(query, new EmployeeAccountRowMapper(), accountId);
//		return employeeAccount;
//	}
//
//	@Override
//	public boolean deleteEmployeeAccount(int accountID) {
//		String query = "delete from employee_account where LIBRARY_ACC_ID= ? ";
//		int rows = jdbcTemplate.update(query, accountID);
//		if (rows > 0)
//			return true;
//		return false;
//	}
//
//	@Override
//	public boolean createEmployeeAccount(EmployeeAccount empAcc) throws AccountAlreadyExists {
//
//		String query = "Insert into employee_Account values(?,?,?)";
//		int res = jdbcTemplate.update(query, empAcc.getAccountId(), empAcc.getNumOfBooks(), empAcc.getEmployeeId());
//		if (res > 0)
//			return true;
//		return false;
//	}
//
//	@Override
//	public boolean accountExists(int accountId) throws EmptyResultDataAccessException {
//
//		EmployeeAccount employeeAccount;
//		String query = "Select * from Employee_account where LIBRARY_ACC_ID= ? ";
//		employeeAccount = jdbcTemplate.queryForObject(query, new EmployeeAccountRowMapper(), accountId);
//		if (employeeAccount != null) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean employeeExists(int empId) throws EmptyResultDataAccessException {
//
//		EmployeeAccount employeeAccount;
//		String query = "Select * from Employee_account where EMPLOYEE_ID= ? ";
//		employeeAccount = jdbcTemplate.queryForObject(query, new EmployeeAccountRowMapper(), empId);
//		if (employeeAccount != null) {
//			return true;
//		}
//		return false;
//	}
//
//	public int numOfBooksIssued(int accountId) {
//
//		EmployeeAccount employeeAccount;
//		String query = "SELECT * FROM EMPLOYEE_ACCOUNT where LIBRARY_ACC_ID= ? ";
//		employeeAccount = jdbcTemplate.queryForObject(query, new EmployeeAccountRowMapper(), accountId);
//		if (employeeAccount != null) {
//			int numBooks = employeeAccount.getNumOfBooks();
//			return numBooks;
//		}
//		return 0;
//	}
//
//	public void decreaseNumBooksIssued(int numBooks, int accountId) {
//
//		String query = "update employee_account set NUM_OF_BOOKS_WITH_EMPLOYEE= ? where LIBRARY_ACC_ID= ? ";
//		jdbcTemplate.update(query, numBooks - 1, accountId);
//	}
//
//	public void increaseNumBooksIssued(int numBooks, int accountId) {
//
//		String query = "update employee_account set NUM_OF_BOOKS_WITH_EMPLOYEE= ? where LIBRARY_ACC_ID= ? ";
//		jdbcTemplate.update(query, numBooks + 1, accountId);
//
//	}
//
//}
