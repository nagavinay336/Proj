package com.bridgetoll;

public class BridgeJob implements Runnable {

	private Plaza p;

	public BridgeJob(Plaza p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			p.showBridge("Bridge " + i);
		}

	}

}
