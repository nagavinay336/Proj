package com.employeeproject;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class EmployeeProjMain {

	public static void main(String[] args) {

		TreeMap<Employee, Project> treeMap = new TreeMap<>();
		treeMap.put(new Employee(101, "Ram"), new Project(1, "First"));
		treeMap.put(new Employee(102, "Sanjay"), new Project(2, "Second"));
		treeMap.put(new Employee(103, "Ramesh"), new Project(2, "Second"));
		treeMap.put(new Employee(104, "Ram"), new Project(1, "First"));
		treeMap.put(new Employee(105, "Bhuvan"), new Project(2, "Second"));
		treeMap.put(new Employee(103, "Ramesh"), new Project(3, "Third"));
		treeMap.put(new Employee(105, "Bhuvan"), new Project(1, "First"));

		System.out.println("Traversal\n");
		for (Entry<Employee, Project> emp : treeMap.entrySet()) {
			System.out.println(emp.getKey() + " " + emp.getValue());
		}
	}

}
