package com.podts.solarserver.world;

public class Velocity {
	
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
	
	public Velocity() {
		
	}
	
	public Velocity(double x, double y) {
		setX(x);
		setY(y);
	}
	
}
