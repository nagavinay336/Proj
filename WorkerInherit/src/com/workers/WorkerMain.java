package com.workers;

public class WorkerMain {
	public static void main(String[] args) {
		Worker w;
		w = new DailyWorker(2.5, "Ram");
		System.out.println(w.getName() + " is getting " + w.pay(10) + " at a rate of " + w.getSalaryRate());
		w = new SalariedWorker(3, "Shyam");
		System.out.println(w.getName() + " is getting " + w.pay(10) + " at a rate of " + w.getSalaryRate());
	}
}
