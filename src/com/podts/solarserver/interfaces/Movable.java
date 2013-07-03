package com.podts.solarserver.interfaces;

import com.podts.solarserver.world.Velocity;

public interface Movable extends Locatable {
	
	public Velocity getVelocity();
	public void setVelocity(Velocity v);
	
}
