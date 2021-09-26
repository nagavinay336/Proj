package com.bucketsort;

import java.util.Collections;
import java.util.Vector;

public class BucketSort {
	private int n;
	private double[] arr;

	public BucketSort(int n) {
		super();
		this.n = n;
		arr = new double[n];
	}

	public BucketSort(int n, double[] arr) {
		this.arr = arr;
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public double[] getArr() {
		return arr;
	}

	public void insertEle(double ele, int ind) {
		this.arr[ind] = ele;
	}

	public BucketSort sort(BucketSort b) {
        @SuppressWarnings("unchecked")
        Vector<Double>[] buckets = new Vector[n];
 
        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Double>();
        }
 
        for (int i = 0; i < n; i++) {
        	double idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
 
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
        return b; 
	}

	public void display() {
		for (double ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
}
