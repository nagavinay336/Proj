package com.multithreads;

class Factorial implements Runnable{
	private int number;

	public Factorial(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public void run() {
		int fact=1;
		while(number>0){
			fact*=number--;
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("factorial is "+fact);
	}
}

class Reverse extends Thread {
	private int number;
	private int result=0;
	
	public int getResult() {
		return result;
	}

	public Reverse(int number) {
		super();
		this.number = number;
	}

	public Reverse() {
		super();
	}
	private void computeReverse() {
		while(number!=0) {
			int rem=number%10;
			result=result*10+rem;
			number/=10;
		}
		System.out.println("Reverse of number is "+result);
	}
	@Override
	public void run() {
//		System.out.println("Thread Started:");
		computeReverse();
//		System.out.println("Thread completed!");
	}

	public void setNumber(int number) {
		this.number = number;
	}
}


public class FactorialMain {

	public static void main(String[] args) {
		Thread t1=new Thread(new Factorial(5));
		Reverse rev=new Reverse(10945);
		t1.start();
		rev.start();
	}

}
