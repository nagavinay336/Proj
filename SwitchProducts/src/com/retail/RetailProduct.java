package com.retail;

public class RetailProduct {
	private int quantitySold;
	private int product;
	public RetailProduct(int n,int n1) {
		product=n;
		quantitySold=n1;
	}
	public double calculateRetail() {
		double sum=0;
		switch(product) {
			case 1: sum+=(22.50*quantitySold);
					break;
			case 2: sum+=(44.50*quantitySold);
					break;
			case 3: sum+=(9.98*quantitySold);
					break;
		}
		return sum;
	}
}
