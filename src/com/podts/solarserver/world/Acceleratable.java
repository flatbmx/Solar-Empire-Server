package com.podts.solarserver.world;

public interface Acceleratable extends Gravitable {
	
	public void moveTo(Location l);
	public void move(HasRotation r, Force f);
	
	public Force getMaximumForce();
	
}
