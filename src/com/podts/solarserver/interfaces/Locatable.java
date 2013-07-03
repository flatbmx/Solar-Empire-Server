package com.podts.solarserver.interfaces;

import com.podts.solarserver.world.Location;

public interface Locatable {
	
	public Location getLocation();
	public void setLocation(Location location);
	
}
