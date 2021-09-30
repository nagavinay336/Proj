package com.synchronizedthreads;

public class ToeJob implements Runnable {

	private TicTacToe ttt;

	public ToeJob(TicTacToe ttt) {
		super();
		this.ttt = ttt;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			ttt.callToe("Toe" + i);
		}
	}
}
