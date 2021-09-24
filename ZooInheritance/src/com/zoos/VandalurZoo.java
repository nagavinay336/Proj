package com.zoos;

import com.animals.*;

public class VandalurZoo {
	private Animals[] ani;
	private int size;

	public void setSize(int size) {
		this.size = size;
		ani = new Animals[this.size];
	}

	public void setData(int ind, Animals obj) {
		ani[ind] = obj;
	}

	public void animalFunctions(int ind) {
		System.out.println(ani[ind].getName() + " says " + ani[ind].speciality() + " ,its weight is "
				+ ani[ind].getWeight() + " with age " + ani[ind].getAge());

	}
}
