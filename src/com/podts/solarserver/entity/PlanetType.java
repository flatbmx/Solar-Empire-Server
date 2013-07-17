package com.podts.solarserver.entity;

import com.podts.solarserver.interfaces.HasName;

public enum PlanetType implements HasName {
	
	A(),
	I(),
	M(),
	R();
	
	@Override
	public String getName() {
		return toString();
	}
	
}
