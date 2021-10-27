package com.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.BookIssue;
import com.bean.EmployeeAccount;

@Repository
public interface EmployeeAccountDao extends JpaRepository<EmployeeAccount, Integer> {

//	@Query("select * from EmployeeAccount where accountId=:accountId")
//	EmployeeAccount getEmployeeAccountDetails(@Param("accountId") int accountId);

	@Transactional
	@Modifying
	@Query("delete from EmployeeAccount where accountId=:accountId")
	boolean deleteEmployeeAccount(@Param("accountId") int accountID);

//	boolean createEmployeeAccount(EmployeeAccount empAcc);

	@Query("select accountId from EmployeeAccount where accountId=:accountId")
	int accountExists(@Param("accountId") int accountId) throws EmptyResultDataAccessException;

	@Query("select accountId from EmployeeAccount where employeeId=:empId")
	public boolean employeeExists(@Param("empId") int empId) throws EmptyResultDataAccessException;

	@Query("select numOfBooks from EmployeeAccount where accountId=:accountId")
	public int numOfBooksIssued(@Param("accountId") int accountId);

	@Transactional
	@Modifying
	@Query("update EmployeeAccount set numOfBooks=numOfBooks-1 where accountId=:accountId")
	public void decreaseNumBooksIssued(@Param("accountId") int accountId);

	@Transactional
	@Modifying
	@Query("update EmployeeAccount set numOfBooks=numOfBooks+1 where accountId=:accountId")
	public void increaseNumBooksIssued(@Param("accountId") int accountId);
}
