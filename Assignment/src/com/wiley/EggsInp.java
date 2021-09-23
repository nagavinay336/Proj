package com.wiley;

public class EggsInp {
	private int num;

	EggsInp(int n) {
		num = n;
	}

	public int getNum() {
		return num;
	}

	public ComputeEggs calcEggs() {
		ComputeEggs c = new ComputeEggs();
		int rem = num % 144;
		c.setGross(num / 144);
		c.setDozen(rem / 12);
		rem = rem % 12;
		c.setEggs(rem);
		return c;
	}
}
