package com.radixsort;

import java.util.Arrays;

public class RadixSort {
	private int n;
	private int[] arr;

	public RadixSort(int n) {
		super();
		this.n = n;
		arr = new int[n];
	}

	public RadixSort(int n, int[] arr) {
		this.arr = arr;
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public int[] getArr() {
		return arr;
	}

	public void insertEle(int ele, int ind) {
		this.arr[ind] = ele;
	}

	public void sort(RadixSort b) {
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	private int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	private void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	public void display() {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
}
