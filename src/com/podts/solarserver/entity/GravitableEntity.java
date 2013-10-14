package com.podts.solarserver.entity;

import com.podts.solarserver.world.Collidable;
import com.podts.solarserver.world.Force;
import com.podts.solarserver.world.Gravitable;
import com.podts.solarserver.world.Location;
import com.podts.solarserver.world.Mass;

public class GravitableEntity extends Entity implements Gravitable, Collidable {
	
	private Mass m;
	private Force f;

	@Override
	public void calculatemove() {
		
	}

	@Override
	public Mass getMass() {
		return m;
	}

	@Override
	public void setMass(Mass m) {
		this.m = m;
	}

	@Override
	public Force getForce() {
		return f;
	}

	@Override
	public void setForce(Force f) {
		this.f = f;
	}

	@Override
	public void Gravitate(Gravitable g) {
		
	}
	
	@Override
	public boolean isColliding(Collidable c) {
		if (c == null || c.getLocation() == null)
			return false;
		return getLocation().distance(c) < Math.max(getCollisionRadius(), c.getCollisionRadius());
	}

	@Override
	public double getCollisionRadius() {
		return m.getVolume();
	}
	
	public GravitableEntity(Location location, Mass m) {
		super(location);
	}
	
}
