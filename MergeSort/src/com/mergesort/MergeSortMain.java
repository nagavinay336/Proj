package com.mergesort;

import java.util.Scanner;

public class MergeSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int n = sc.nextInt();
		MergeSort bs = new MergeSort(n);
		System.out.println("Enter the array Elements: ");

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			bs.insertEle(a, i);
		}

		bs.sort(bs,0,n-1);
		System.out.println("Printing sorted array in main: ");
		int arr[] = bs.getArr();
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
		System.out.println("Printing sorted array using display method: ");
		bs.display();
		sc.close();
	}

}
