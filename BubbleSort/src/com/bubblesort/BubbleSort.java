package com.bubblesort;

public class BubbleSort {
	private int n;
	private int[] arr;

	public BubbleSort(int n) {
		super();
		this.n = n;
		arr = new int[n];
	}

	public BubbleSort(int n, int[] arr) {
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

	public BubbleSort sort(BubbleSort b) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (b.arr[j] > b.arr[j + 1]) {
					int temp = b.arr[j];
					b.arr[j] = b.arr[j + 1];
					b.arr[j + 1] = temp;
				}
			}
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



//Space Complexity - O(1)

//Time Complexity - 
//Best Case - O(n)
//Worst and Average Case - O(n^2)
