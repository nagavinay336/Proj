package com.empstack;

public class StackMain {

	public static void main(String[] args) {

		Stack stack = new Stack();
		stack.push(new Employee(1, "Abc", "associate", 10000));
		stack.push(new Employee(2, "Def", "SE", 15000));
		stack.push(new Employee(3, "Ghi", "SDE", 15000));
		stack.push(new Employee(3, "Ghi", "SDE", 15000));
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
	}

}
