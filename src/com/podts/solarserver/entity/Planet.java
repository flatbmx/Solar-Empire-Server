package com.podts.solarserver.entity;

import com.podts.solarserver.world.Location;
import com.podts.solarserver.world.Mass;

public class Planet extends GravitableEntity {

	public Planet(Location location, Mass m) {
		super(location, m);
	}
	
	public Planet(String name, Location location, Mass m) {
		super(location,m);
		setName(name);
	}
	
}
