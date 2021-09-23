package com.retail;

import java.util.Scanner;

public class RetailMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product number and Quantity");
		int n=sc.nextInt();
		int n1=sc.nextInt();
		RetailProduct rp=new RetailProduct(n,n1);
		double tot=rp.calculateRetail();
		System.out.println("Total Price for product "+n+" of quantity "+n1+" is : "+tot);
		sc.close();
	}

}
