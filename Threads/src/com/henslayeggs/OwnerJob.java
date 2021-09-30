package com.henslayeggs;

public class OwnerJob implements Runnable {
	private Selling s;

	public OwnerJob(Selling s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		for (int i = 1; i < 51; i++) {
			s.showOwner("Owner gained Rs " + (i * 2));

		}

	}

}
