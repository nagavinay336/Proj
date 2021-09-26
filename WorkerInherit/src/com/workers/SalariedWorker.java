package com.workers;

public class SalariedWorker extends Worker {

	private int hours;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public SalariedWorker(double salaryRate, String name) {
		super(salaryRate, name);
	}

	public int pay(int hours) {
		return 100 * hours;
	}

}
