package com.podts.solarserver.ship;

public class Engines extends ShipCategory {
	
	private double fuel, maxfuel;
	private double speed, maxspeed, acceleration;
	
	public double getFuel() {
		return fuel;
	}
	
	public double getFuelCapacity() {
		return maxfuel;
	}
	
	public double getFuelPercent() {
		return fuel/maxfuel;
	}
	
	public double getSpeedPercent() {
		return speed/maxspeed;
	}
	
	public double getAcceleration() {
		return acceleration;
	}
	
	public Engines(double maxspeed, double acceleration, double maxfuel) {
		super("Engines");
	}
	
}
