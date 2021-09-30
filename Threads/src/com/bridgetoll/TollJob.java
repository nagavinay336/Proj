package com.bridgetoll;

public class TollJob implements Runnable {
	private Plaza p;

	public TollJob(Plaza p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			p.showToll("Toll " + i);

		}

	}

}
