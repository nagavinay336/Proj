package com.bucketsort;

import java.util.Scanner;

public class BucketSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int n = sc.nextInt();
		BucketSort bs = new BucketSort(n);
		System.out.println("Enter the array Elements: ");

		for (int i = 0; i < n; i++) {
			double a = sc.nextDouble();
			bs.insertEle(a, i);
		}

		bs.sort(bs);
		System.out.println("Printing sorted array in main: ");
		double arr[] = bs.getArr();
		for (double ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
		System.out.println("Printing sorted array using display method: ");
		bs.display();
		sc.close();
	}

}
