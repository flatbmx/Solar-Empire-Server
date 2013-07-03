package com.podts.solarserver.world;

public class Location {
	
	private System system;
	private double x, y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
	
	public Location(System system, double x, double y) {
		setSystem(system);
		setX(x);
		setY(y);
	}
	
}
