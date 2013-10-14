package com.podts.solarserver.world;

public interface Movable extends Locatable {
	
	public Velocity getVelocity();
	public void setVelocity(Velocity v);
	
	public void calculatemove();
	
}
