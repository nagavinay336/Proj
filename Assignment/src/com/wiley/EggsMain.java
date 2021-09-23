package com.wiley;

import java.util.Scanner;

public class EggsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of eggs: ");
		int n = sc.nextInt();
		EggsInp ei = new EggsInp(n);
		ComputeEggs ce = ei.calcEggs();
		System.out.println("Number of eggs are: " + ce.getGross() + " gross , " + ce.getDozen() + " dozen , "
				+ ce.getEggs() + " eggs");

	}

}
