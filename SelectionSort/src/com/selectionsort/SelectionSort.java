package com.selectionsort;

public class SelectionSort {
	private int n;
	private int[] arr;

	public SelectionSort(int n) {
		super();
		this.n = n;
		arr = new int[n];
	}

	public SelectionSort(int n, int[] arr) {
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

	public SelectionSort sort(SelectionSort b) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (b.arr[j] < b.arr[min]) {
					min = j;
				}
			}
			int temp = b.arr[min];
			b.arr[min] = b.arr[i];
			b.arr[i] = temp;
		}
		return b;
	}

	public void display() {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
}



//Space Complexity - O(n)
//Time Complexity - Best case,Worst Case and Average Case - O(n^2)