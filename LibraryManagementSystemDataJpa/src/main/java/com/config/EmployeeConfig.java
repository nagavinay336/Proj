//package com.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.persistance.BookDao;
//import com.persistance.BookIssueDao;
//import com.persistance.BookIssueDaoImplementation;
//import com.persistance.EmployeeAccountDao;
//import com.persistance.EmployeeAccountDaoImplementation;
//import com.persistance.EmployeeDao;
//import com.persistance.EmployeeDaoImplementation;
//import com.presentation.EmployeePresentation;
//import com.presentation.EmployeePresentationImplementation;
//import com.service.BookIssueService;
//import com.service.BookIssueServiceImplementation;
//import com.service.BookService;
//import com.service.BookServiceImplementation;
//import com.service.EmployeeAccountService;
//import com.service.EmployeeAccountServiceImplementation;
//import com.service.EmployeeService;
//import com.service.EmployeeServiceImplementation;
//
//@Configuration
//public class EmployeeConfig {

//	@Bean("empPresentation")
//	public EmployeePresentation getPresentation() {
//		return new EmployeePresentationImplementation();
//	}
//
//	@Bean
//	public BookIssueService bookIssueService() {
//		return new BookIssueServiceImplementation();
//	}
//
//	@Bean
//	public BookService bookService() {
//		return new BookServiceImplementation();
//	}
//
//	@Bean
//	public EmployeeService employeeService() {
//		return new EmployeeServiceImplementation();
//	}
//
//	@Bean
//	public EmployeeAccountService employeeAccountService() {
//		return new EmployeeAccountServiceImplementation();
//	}
//
//	@Bean
//	public EmployeeDao employeeDao() {
//		return new EmployeeDaoImplementation();
//	}
//
//	@Bean
//	public EmployeeAccountDao employeeAccountDao() {
//		return new EmployeeAccountDaoImplementation();
//	}
//
//	@Bean
//	public BookDao bookDao() {
//		return new BookDaoImplementation();
//	}
//
//	@Bean
//	public BookIssueDao bookIssueDao() {
//		return new BookIssueDaoImplementation();
//	}
//}
