package com.vehicles;

public class Bus extends Vehicle {

	private int passenger;

	public Bus(int noOfWheels, String model, String color, int passenger) {
		super(noOfWheels, model, color);
		this.passenger = passenger;
	}

	public int getPassenger() {
		return passenger;
	}

	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	@Override
	public void rideVehicle() {
		System.out
				.println("I am Bus riding with : " + noOfWheels + " wheels and with extra passengers of " + passenger);
	}
}
