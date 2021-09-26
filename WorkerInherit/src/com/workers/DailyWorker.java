package com.workers;

public class DailyWorker extends Worker {

	private int days;
	
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public DailyWorker(double salaryRate, String name) {
		super(salaryRate, name);
	}

	public int pay(int days) {
		return 500*days;
	}
}
