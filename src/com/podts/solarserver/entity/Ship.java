package com.podts.solarserver.entity;

import com.podts.solarserver.world.Location;

public class Ship extends Entity {
	
	private double energy;
	
	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public Ship(Location location) {
		super(location);
	}
	
}
