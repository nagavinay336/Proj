package com.constr;

public class Height {
	private int feet;
	private int inch;

	public Height() {
		feet = 0;
		inch = 0;
	}

	Height(int f, int i) {
		feet = f;
		if (i > 11) {
			inch = i % 12;
			int rem = i / 12;
			feet += rem;
		} else {
			inch = i;
		}
	}

	Height(int f) {
		feet = f;
		inch = 0;
	}

	public void addHeight(Height h1, Height h2) {
		Height temp = new Height();
		temp.feet = h1.feet + h2.feet;
		int t1 = h1.inch + h2.inch;
		if (t1 > 11) {
			temp.inch = t1 % 12;
			int rem = t1 / 12;
			temp.feet += rem;
		} else {
			temp.inch = t1;
		}
		System.out.println("Total Height= " + temp.feet + " feet " + temp.inch + " inches");
	}

}
