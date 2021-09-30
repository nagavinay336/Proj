package com.henslayeggs;

public class PlazaMain {

	public static void main(String[] args) {
		Selling s = new Selling();
		HensJob hensJob = new HensJob(s);
		OwnerJob ownerJob = new OwnerJob(s);

		Thread t1 = new Thread(hensJob, "Hen");
		Thread t2 = new Thread(ownerJob, "Owner");

		t1.start();
		t2.start();

	}

}
