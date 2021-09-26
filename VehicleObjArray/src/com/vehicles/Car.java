package com.vehicles;

public class Car extends Vehicle {

	private int luxuryLevel;

	public Car(int noOfWheels, String model, String color, int luxuryLevel) {
		super(noOfWheels, model, color);
		this.luxuryLevel = luxuryLevel;
	}

	public int getLuxuryLevel() {
		return luxuryLevel;
	}

	public void setLuxuryLevel(int luxuryLevel) {
		this.luxuryLevel = luxuryLevel;
	}

	@Override
	public void rideVehicle() {
		System.out.println("I am Car riding with : " + noOfWheels + " wheels and with luxury level " + luxuryLevel);
	}

}
