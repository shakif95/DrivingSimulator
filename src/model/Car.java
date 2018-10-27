package model;

import java.util.Comparator;

public class Car implements Comparable<Car> {
	private int id;
	private int lane;
	private int speed;
	private int max_speed;
	private Position position;

	public Car() {

	}

	public Car(int id, int lane, int speed, int max_speed, Position position) {
		this.id = id;
		this.lane = lane;
		this.speed = speed;
		this.max_speed = max_speed;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMax_speed() {
		return max_speed;
	}

	public void setMax_speed(int max_speed) {
		this.max_speed = max_speed;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", lane=" + lane + ", speed=" + speed + ", max_speed=" + max_speed + "]";
	}

	/*
	 * @Override public int compareTo(Car o1, Car o2) {
	 * if(o1.getPosition().getY() > o2.getPosition().getY()) return 1; else
	 * if(o1.getPosition().getY() == o2.getPosition().getY()) return 0; else
	 * return -1; }
	 */

	@Override
	public int compareTo(Car o) {
		if (o.getPosition().getY() > getPosition().getY())
			return -1;
		else if (o.getPosition().getY() == getPosition().getY())
			return 0;
		else
			return 1;
	}

}
