package com.bridgetoll;

public class PlazaMain {

	public static void main(String[] args) {
		Plaza p = new Plaza();
		BridgeJob bridgeJob = new BridgeJob(p);
		TollJob tollJob = new TollJob(p);

		Thread t1 = new Thread(bridgeJob, "Bridge");
		Thread t2 = new Thread(tollJob, "Toll");

		t1.start();
		t2.start();

	}

}
