package controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Car;
import model.Position;

public class SimulatorController implements ISimulatorController {

	public static List<Car> cars = new LinkedList<>();

	@Override
	public void addCar(Car car) {
		cars.add(car);
	}

	@Override
	public int canOverTake(Car front_car) {
		return canTakeLeft(front_car) ? -1 : 
			(canTakeRight(front_car) ? 1 : 0);

	}

	private boolean canTakeRight(Car car) {
		if(car.getLane()+1 >= 4)
			return false;
		List<Car> leftLane = getCarByLanes(car.getLane()+1);
		if(leftLane != null){
			for(Car c: leftLane){
				if(c.getPosition().getY() == car.getPosition().getY()
						|| c.getPosition().getY() == car.getPosition().getY()+1)
					return false;
			}
		}
		return true;
	}

	private boolean canTakeLeft(Car car) {
		if(car.getLane()-1 <= 0)
			return false;
		List<Car> leftLane = getCarByLanes(car.getLane()-1);
		if(leftLane != null){
			for(Car c: leftLane){
				if(c.getPosition().getY() == car.getPosition().getY()
						|| c.getPosition().getY() == car.getPosition().getY()+1)
					return false;
			}
		}
		return true;
	}

	public void run(int time) {
		for (int i = 1; i <= time; i++) {
			System.out.println("Iteration: "+i);
			for (Car c : cars) {
				simulateByOne(c, i);
			}
			printCars();
		}
		
	}

	private void simulateByOne(Car car, int time) {
		Position position = new Position(car.getLane(), (car.getPosition().getY()+car.getSpeed()));
		List<Car> carl = getCarByLanes(car.getLane()); 
		if(carl != null){
			Collections.sort(carl);
			
			for(Car c: carl){
				if(c.getId() != car.getId() && c.getPosition().getY() >= position.getY()){
					position.setX(car.getLane()+changeLaneOrLowerSpeed(car, c));
					position.setY(car.getPosition().getY()+car.getMax_speed());
				}
					
			}
		}
		car.setPosition(position);
	}
	
	private List<Car> getCarByLanes(int lane){
		List<Car> sameLaneCars = new LinkedList<>();
		
		for(Car c: cars){
			if(c.getLane() == lane)
				sameLaneCars.add(c);
		}
		
		return sameLaneCars.size() > 0 ? sameLaneCars : null;
	}

	public void printCars() {
		for(Car c: cars)
			System.out.println(c.getPosition().toString());
	}
	
	private int changeLaneOrLowerSpeed(Car c, Car fcar){
		if(canOverTake(c) > 0){
			c.getPosition().setX(c.getLane()+1);
			c.setLane(c.getLane()+1);
			return 1;
		}
		else if(canOverTake(c) < 0){
			c.getPosition().setX(c.getLane()-1);
			c.setLane(c.getLane()-1);
			return -1;
		}
		else
			c.setSpeed(fcar.getSpeed());
		return 0;
	}
	
}
