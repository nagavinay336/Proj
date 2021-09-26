package com.vehicles;

import java.util.Scanner;

public class Road {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of Vehicles: ");
		int n=sc.nextInt();
		Vehicle v[]=new Vehicle[n];
		for(int i=0;i<n;i++) {
			int choice;
			System.out.println("Enter the type of Vehicle:\n 1. Truck \n 2.Bus \n 3.Car");
			choice=sc.nextInt();
			
			System.out.println("Enter no of wheels of vehicle: "+(i+1));
			int noOfWheels=sc.nextInt();
			System.out.println("Enter the color");
			String color=sc.next();
			System.out.println("Enter the model of the vehicle");
			String model=sc.next();
			if(choice==1) {
				System.out.println("Enter the load in Truck");
				int load=sc.nextInt();
				v[i]=new Truck(noOfWheels,model,color,load);
			}
			else if(choice==2) {
				System.out.println("Enter the passengers in Bus");
				int load=sc.nextInt();
				v[i]=new Bus(noOfWheels,model,color,load);
			}
			else if(choice==3) {
				System.out.println("Enter the luxury level in Car");
				int load=sc.nextInt();
				v[i]=new Car(noOfWheels,model,color,load);
			}
			else {
				System.out.println("Calling default Vehicle");
				v[i]=new Vehicle(noOfWheels,model,color);
			}
		}
		for(int i=0;i<n;i++) {
			v[i].rideVehicle();
		}
		sc.close();
	}
}
