package com.podts.solarserver.world;

public enum Direction implements HasRotation {
	
	UP(0,-1,0),
	DOWN(0,1,180),
	LEFT(-1,0,270),
	RIGHT(1,0,90);
	
	private final double x,y,rot;
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	@Override
	public double getRotation() {
		return rot;
	}

	Direction(double x, double y, double rot) {
		this.x = x;
		this.y = y;
		this.rot = rot;
	}
	
}
