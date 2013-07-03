package com.podts.solarserver.entity;

import com.podts.solarserver.interfaces.Locatable;
import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.world.Location;

public class Entity implements Locatable, Namable {
	
	private String name;
	private Location location;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
		// Update location to all players.
	}
	
	public Entity(Location location) {
		this.location = location;
	}
	
}
