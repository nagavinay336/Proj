package com.workers;

public class Worker {

	private double salaryRate;
	private String name;

	public double getSalaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(double salaryRate) {
		this.salaryRate = salaryRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Worker(double salaryRate, String name) {
		super();
		this.salaryRate = salaryRate;
		this.name = name;
	}
	public int pay(int days) {
		return days;
	}

}
