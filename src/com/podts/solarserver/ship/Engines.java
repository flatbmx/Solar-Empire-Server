package com.podts.solarserver.ship;

import com.podts.solarserver.world.Force;

public class Engines extends ShipCategory {
	
	private double fuel, maxfuel;
	private double speed, maxspeed, acceleration;
	private Force maxforce;
	
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
	
	public Force getMaximumForce() {
		return maxforce;
	}
	
	public Engines(double maxspeed, double acceleration, double maxfuel) {
		super("Engines");
	}
	
}
