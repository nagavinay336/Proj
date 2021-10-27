//package com.client;
//
//import java.util.Scanner;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.presentation.EmployeePresentation;
//
//public class EmployeeMain {
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
////		EmployeePresentation employeePresentation = new EmployeePresentationImplementation();
//
//		ApplicationContext springContainer = new ClassPathXmlApplicationContext("emp.xml");
////		ApplicationContext springContainer = new AnnotationConfigApplicationContext(EmployeeConfig.class);
//
//		EmployeePresentation employeePresentation = (EmployeePresentation) springContainer.getBean("empPresentation");
//
//		System.out.println("Enter 1: For logging into the account\n2.For Creating a new Account");
//		int choice = scanner.nextInt();
//		if (choice == 1) {
//			System.out.println("Enter your account Id: ");
//			int accountId = scanner.nextInt();
//			employeePresentation.showMenu(accountId);
//		} else if (choice == 2) {
//			System.out.println("Creating your account\n");
//			employeePresentation.performMenu(7, 0);
//			System.out.println("To loging to your account\n");
//			System.out.println("Enter your account Id: ");
//			int accountId = scanner.nextInt();
//			employeePresentation.showMenu(accountId);
//		}
//
////		while (true) {
////			
////			System.out.println("Enter choice: ");
////			int choice = scanner.nextInt();
////			employeePresentation.performMenu(choice);
////		}
//
//		scanner.close();
//	}
//
//}
