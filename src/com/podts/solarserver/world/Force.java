package com.podts.solarserver.world;

public class Force {
	
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
	
	public Force() {
		
	}
	
	public Force(double x, double y) {
		setX(x);
		setY(y);
	}
	
}
