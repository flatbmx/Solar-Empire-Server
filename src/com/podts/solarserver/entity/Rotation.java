package com.podts.solarserver.entity;

import com.podts.solarserver.world.HasRotation;

public class Rotation implements HasRotation {
	
	private volatile double rotation;
	
	@Override
	public double getRotation() {
		return rotation;
	}
	
	public Rotation(double r) {
		rotation = r;
	}
	
}
