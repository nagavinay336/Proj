package com.zoos;

import com.animals.*;
public class ZooMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animals ani=new Tiger();
		ani.setName("Tiger");
		ani.setAge(20);
		ani.setWeight(100);
		
		Animals ani2=new Monkey();
		ani2.setName("Monkey");
		ani2.setAge(10);
		ani2.setWeight(10);
		
		Animals ani3=new Lion();
		ani3.setName("Lion");
		ani3.setAge(15);
		ani3.setWeight(120);
		
		Animals ani4=new Giraffe();
		ani4.setName("Giraffe");
		ani4.setAge(20);
		ani4.setWeight(180);
		
		Animals ani5=new Elephant();
		ani5.setName("Elephant");
		ani5.setAge(25);
		ani5.setWeight(290);
		
		Animals ani6=new Deer();
		ani6.setName("Deer");
		ani6.setAge(20);
		ani6.setWeight(70);
		
		VandalurZoo vz=new VandalurZoo();
		vz.setSize(6);
		vz.setData(0, ani);
		vz.setData(1, ani2);
		vz.setData(2, ani3);
		vz.setData(3, ani4);
		vz.setData(4, ani5);
		vz.setData(5, ani6);
		
		for(int i=0;i<6;i++) {
			vz.animalFunctions(i);
		}
	}

}
