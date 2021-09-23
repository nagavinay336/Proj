package com.reverse;

public class ReverseNum {
	private int number, reversenum;

	public int getReversenum() {
		return reversenum;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void getReverse() {
		reversenum=0;
		while (number != 0) {
			int rem = number % 10;
			number=number/10;
			reversenum=reversenum*10+rem;
		}
	}
}
