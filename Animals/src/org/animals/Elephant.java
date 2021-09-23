package org.animals;

public class Elephant {
	private String color;
	private int weight;
	private int age;
	private boolean veg,climb;
	
	public boolean canClimb() {
		return climb;
	}

	public boolean isVeg() {
		return veg;
	}

	public String getColor() {
		return color;
	}


	public int getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public Elephant(String color,int weight,int age,boolean veg,boolean climb){
		this.color=color;
		this.weight=weight;
		this.age=age;
		this.climb=climb;
		this.veg=veg;
	}
}
