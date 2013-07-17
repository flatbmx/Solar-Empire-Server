package com.podts.solarserver.world;

public interface Collidable extends Locatable {
	
	public boolean isColliding(Collidable c);
	public double getCollisionRadius();
	
}
