package controller;

import model.Car;

public interface ISimulatorController {
	public void addCar(Car car);
	public int canOverTake(Car front_car);
	public void printCars();
	public void run(int time);
}
