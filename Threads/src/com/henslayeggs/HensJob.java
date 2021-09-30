package com.henslayeggs;

public class HensJob implements Runnable {

	private Selling s;

	public HensJob(Selling s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		for (int i = 1; i < 51; i++) {
			s.showHens("Hen laid the egg-" + i);
		}

	}

}
