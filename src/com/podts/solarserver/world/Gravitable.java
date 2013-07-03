package com.podts.solarserver.world;

public interface Gravitable extends Movable {
	
	public Mass getMass();
	public void setMass(Mass m);
	
	public Force getForce();
	public void setForce(Force f);
	
	public void Gravitate(Gravitable g);
	
}
