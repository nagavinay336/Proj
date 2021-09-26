package com.vehicles;

public class Truck extends Vehicle {

	private int load;

	public Truck(int noOfWheels, String model, String color,int load) {
		super(noOfWheels, model, color);
		this.load=load;
	}

	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}

	@Override
	public void rideVehicle() {
		System.out.println("I am Truck riding with : " + noOfWheels + " wheels and with extra load of "+load);
	}
}
