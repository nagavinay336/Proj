package com.zoo;

import org.animals.*;

public class VandalurZoo {
	public static void main(String[] args) {
		Lion l = new Lion("Yellow", 80, 20, false, false);
		Tiger t = new Tiger("Brown", 75, 18, false, false);
		Monkey m = new Monkey("Grey", 20, 15, true, true);
		Deer d = new Deer("Brown", 40, 22, true, false);
		Elephant e = new Elephant("Grey", 250, 15, true, false);
		Giraffe g = new Giraffe("Brown", 180, 30, true, false);
		
		if (m.canClimb()) {
			System.out.println("Monkey can climb trees");
		} else {
			System.out.println("Monkey Cant climb");
		}
		if (t.isVeg()) {
			System.out.println("Tiger is vegetarian");
		} else {
			System.out.println("Tiger is non-vegetarian");
		}
		System.out.println("Lions age= " + l.getAge());
		System.out.println("Elephants weight= " + e.getWeight());
		System.out.println("Giraffes color= " + g.getColor());
	}
}
