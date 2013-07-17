package com.podts.solarserver.ship;

import com.podts.solarserver.interfaces.HasName;

public abstract class ShipCategory implements HasName {
	
	private Ship ship;
	private String name;
	
	@Override
	public String getName() {
		return name;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public void setShip(Ship s) {
		ship = s;
	}
	
	public ShipCategory(String name) {
		if ( name == null)
			return;
		this.name = name;
	}
	
}
