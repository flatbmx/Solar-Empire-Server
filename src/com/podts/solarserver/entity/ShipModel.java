package com.podts.solarserver.entity;

import com.podts.solarserver.Util;
import com.podts.solarserver.interfaces.HasDescription;
import com.podts.solarserver.interfaces.HasName;
import com.podts.solarserver.ship.Engines;
import com.podts.solarserver.world.Mass;

public enum ShipModel implements Identifiable, HasName, HasDescription {
	
	GARBAGE_BARGE(1, "A stinky barge.", new Engines(1,1,10)),
	IMPERAL_CRUISER(2, "A nice shiny ship.", new Engines(1,1,10));
	
	private final int id;
	private final String description;
	private final Mass mass;
	private final Engines engines;
	
	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public String toString() {
		return Util.titleCase(super.toString().replace("_", " "));
	}
	
	@Override
	public String getName() {
		return toString();
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public Mass getMass() {
		return mass;
	}
	
	public Engines getEngines() {
		return engines;
	}
	
	ShipModel(int id, String description, Engines e) {
		this.id = id;
		this.description = description;
		mass = new Mass(0, 0);
		engines = e;
	}
	
}
