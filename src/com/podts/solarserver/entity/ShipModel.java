package com.podts.solarserver.entity;

import com.podts.solarserver.Util;
import com.podts.solarserver.interfaces.HasDescription;
import com.podts.solarserver.interfaces.HasName;

public enum ShipModel implements HasName, HasDescription {
	
	GARBAGEBARGE("A stinky barge."),
	IMPERALCRUISER("A nice shiny ship.");
	
	private String description;
	
	@Override
	public String toString() {
		return Util.titleCase(super.toString());
	}
	
	@Override
	public String getName() {
		return toString();
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	ShipModel() {
	}
	
	ShipModel(String description) {
		this.description = description;
	}
	
}
