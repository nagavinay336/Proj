package com.synchronizedthreads;

public class TacJob implements Runnable {

	private TicTacToe ttt;

	public TacJob(TicTacToe ttt) {
		super();
		this.ttt = ttt;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			ttt.callTac("Tac" + i);
		}
	}
}
