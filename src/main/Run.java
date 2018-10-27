package main;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import controller.ISimulatorController;
import controller.SimulatorController;
import model.Car;
import model.Position;

public class Run {
	public static ISimulatorController crtl = new SimulatorController();
	public static void main(String[] args) {
		int numberOfCars;
		Scanner sc = new Scanner(System.in);
		 
		
		
		System.out.println("Enter number of cars: ");
		numberOfCars = sc.nextInt();
		
		for(int i=1;i<=numberOfCars;i++){
			int lane = sc.nextInt();
			int position = sc.nextInt();
			int speed = sc.nextInt();
			int max_speed = sc.nextInt();
			
			crtl.addCar(new Car(i, lane, speed, max_speed, new Position(lane, position)));
		}				
		System.out.println("Initially:");
		crtl.printCars();
		crtl.run(5);
		
		sc.close();
	}
	
	

}
