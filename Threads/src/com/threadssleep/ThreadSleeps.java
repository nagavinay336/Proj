package com.threadssleep;

class Thread1 implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			Thread t = Thread.currentThread();
			System.out.println("ID: " + t.getId() + "\tName: " + t.getName() + "\tIsalive: " + t.isAlive()
					+ "\t Status: " + t.getState() + "\t Priority: " + t.getPriority());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Thread Sleep Interrupted");
			}
		}
	}

}

public class ThreadSleeps {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread1());
		Thread t3 = new Thread(new Thread1());
		Thread t4 = new Thread(new Thread1());
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
