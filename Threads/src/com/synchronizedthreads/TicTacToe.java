package com.synchronizedthreads;

public class TicTacToe {

	private int ele = 0;

	synchronized public void callTic(String tic) {
		while (ele != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(Thread.currentThread().getName() + ": " + tic + " \t");
		ele++;
		notifyAll();
	}

	synchronized public void callTac(String tac) {
		while (ele != 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(Thread.currentThread().getName() + ": " + tac + " \t");
		ele++;
		notifyAll();
	}

	synchronized public void callToe(String toe) {
		while (ele != 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + ": " + toe);
		ele = 0;
		notifyAll();
	}
}
