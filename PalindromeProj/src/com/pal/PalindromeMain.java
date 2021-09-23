package com.pal;

public class PalindromeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome p=new Palindrome();
		p.setNumber(1234);
		p.checkPalindrome();
		Boolean sts=p.getStatus();
		if(sts) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}
	}

}
