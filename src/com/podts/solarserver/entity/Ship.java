package com.podts.solarserver.entity;

import com.podts.solarserver.interfaces.ShipOwner;
import com.podts.solarserver.world.Location;

public class Ship extends Entity {
	
	private ShipOwner owner;
	private ShipModel model;
	private double energy;
	
	public ShipOwner getOwner() {
		return owner;
	}
	
	public ShipModel getModel() {
		return model;
	}
	
	public double getEnergy() {
		return energy;
	}
	
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	
	public Ship(ShipOwner owner, ShipModel model, Location location) {
		super(location);
		this.owner = owner;
		this.model = model;
	}
	
}
