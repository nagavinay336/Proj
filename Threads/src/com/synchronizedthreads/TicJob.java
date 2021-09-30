package com.synchronizedthreads;

public class TicJob implements Runnable {

	private TicTacToe ttt;

	public TicJob(TicTacToe ttt) {
		super();
		this.ttt = ttt;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			ttt.callTic("Tic" + i);
		}
	}
}
