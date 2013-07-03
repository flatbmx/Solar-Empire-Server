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
	
	public boolean isInGalaxy(Galaxy g) {
		if (g == null)
			return false;
		if (system == null)
			return false;
		if (system.getGalaxy() == null)
			return false;
		return g.getName().equals(system.getGalaxy().getName());
	}
	
	public Location(System system, double x, double y) {
		setSystem(system);
		setX(x);
		setY(y);
	}
	
}
