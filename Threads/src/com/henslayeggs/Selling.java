package com.henslayeggs;

public class Selling {

	private boolean flag = true;

	/*
	 * Thread should show Question when flag is true, otherwise Thread will go in
	 * suspended state
	 */
	synchronized public void showHens(String hen) {
		if (flag == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(Thread.currentThread().getName() + " : " + hen + "  ");
		flag = false;
		notify();
	}

	/*
	 * Thread should show Answer when flag is false, otherwise Thread will go in
	 * suspended state
	 */
	synchronized public void showOwner(String owner) {
		if (flag == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + owner);
		flag = true;
		notify();
	}
}
