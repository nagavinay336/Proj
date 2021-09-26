package com.mergesort;

public class MergeSort {
	private int n;
	private int[] arr;

	public MergeSort(int n) {
		super();
		this.n = n;
		arr = new int[n];
	}

	public MergeSort(int n, int[] arr) {
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

	public void sort(MergeSort b, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sort(b, l, m);
			sort(b, m + 1, r);
			merge(b, l, m, r);
		}
	}

	void merge(MergeSort b, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public void display() {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
}

//Space Complexity - O(n)

//Time Complexity - 
//Best, Worst and Average Case - O(n*log(n))