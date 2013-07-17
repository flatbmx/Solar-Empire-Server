package com.podts.solarserver.ship;

import com.podts.solarserver.life.Atmosphere;

public class LifeSupport extends ShipCategory {
	
	private Atmosphere env;
	
	public Atmosphere getEnvironment() {
		return env;
	}
	
	public LifeSupport(Ship s) {
		super("Life Support");
	}

}
