package com.podts.solarserver.world;

import com.podts.solarserver.interfaces.HasName;

public class System implements HasName {
	
	private String name;
	private Galaxy galaxy;
	private double radius;
	
	@Override
	public String getName() {
		return name;
	}
	
	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Galaxy galaxy) {
		if (this.galaxy != null)
			this.galaxy.removeSystem(this);
		this.galaxy = galaxy;
		this.galaxy.addSystem(this);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public System(String name) {
		this.name = name;
		radius = 5000;
	}
	
	public System(String name, double radius) {
		this.name = name;
		this.radius = radius;
	}
	
}
