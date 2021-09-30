package com.bridgetoll;

public class Plaza {

	private boolean flag = true;

	/*
	 * Thread should show Question when flag is true, otherwise Thread will go in
	 * suspended state
	 */
	synchronized public void showBridge(String bridge) {
		if (flag == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(Thread.currentThread().getName() + " : " + bridge + "  ");
		flag = false;
		notify();
	}

	/*
	 * Thread should show Answer when flag is false, otherwise Thread will go in
	 * suspended state
	 */
	synchronized public void showToll(String toll) {
		if (flag == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " : " + toll);
		flag = true;
		notify();
	}
}
