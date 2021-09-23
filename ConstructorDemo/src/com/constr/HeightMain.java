package com.constr;

public class HeightMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Height h = new Height();
		Height h1 = new Height(5, 11);
		Height h2 = new Height(6, 5);
		h.addHeight(h1, h2);
		
		
		h1 = new Height(1, 24);
		h2 = new Height();
		h.addHeight(h1, h2);
	}

}
