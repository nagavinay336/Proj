package com.synchronizedthreads;

public class TicTacToeMain {

	public static void main(String[] args) {
		TicTacToe tt = new TicTacToe();
		TicJob ticJob = new TicJob(tt);
		TacJob tacJob = new TacJob(tt);
		ToeJob toeJob = new ToeJob(tt);

		Thread t1 = new Thread(ticJob, "Ticker");
		Thread t2 = new Thread(tacJob, "Tacker");
		Thread t3 = new Thread(toeJob, "Toeker");

		t1.start();
		t2.start();
		t3.start();
	}

}
