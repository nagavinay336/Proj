package com.pal;

import com.reverse.ReverseNum;

public class Palindrome {
	private int number;
	private boolean status;

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean getStatus() {
		return status;
	}

	public void checkPalindrome() {
		ReverseNum rv = new ReverseNum();
		rv.setNumber(number);
		rv.getReverse();
		if (rv.getReversenum() == number) {
			status = true;
		} else {
			status = false;
		}
	}
}
