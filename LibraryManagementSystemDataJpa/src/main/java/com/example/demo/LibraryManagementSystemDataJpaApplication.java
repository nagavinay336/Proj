package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.presentation.EmployeePresentation;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.persistence")
@EntityScan(basePackages = "com.bean")
public class LibraryManagementSystemDataJpaApplication implements CommandLineRunner{

	@Autowired
	EmployeePresentation employeePresentation;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
//		EmployeePresentation employeePresentation = new EmployeePresentationImplementation();

//		ApplicationContext springContainer = new ClassPathXmlApplicationContext("emp.xml");
//		ApplicationContext springContainer = new AnnotationConfigApplicationContext(EmployeeConfig.class);

//		EmployeePresentation employeePresentation = (EmployeePresentation) springContainer.getBean("empPresentation");

		System.out.println("Enter 1: For logging into the account\n2.For Creating a new Account");
		int choice = scanner.nextInt();
		if (choice == 1) {
			System.out.println("Enter your account Id: ");
			int accountId = scanner.nextInt();
			employeePresentation.showMenu(accountId);
		} else if (choice == 2) {
			System.out.println("Creating your account\n");
			employeePresentation.performMenu(7, 0);
			System.out.println("To loging to your account\n");
			System.out.println("Enter your account Id: ");
			int accountId = scanner.nextInt();
			employeePresentation.showMenu(accountId);
		}

//		while (true) {
//			
//			System.out.println("Enter choice: ");
//			int choice = scanner.nextInt();
//			employeePresentation.performMenu(choice);
//		}

//		scanner.close();
	}

}
