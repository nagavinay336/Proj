package com.vehicles;

public class Vehicle {
	int noOfWheels;
	String model, color;

	public Vehicle(int noOfWheels, String model, String color) {
		super();
		this.noOfWheels = noOfWheels;
		this.model = model;
		this.color = color;
	}

	public int getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void rideVehicle() {
		System.out.println("I am riding with : " + noOfWheels + " wheels");
	}
}
