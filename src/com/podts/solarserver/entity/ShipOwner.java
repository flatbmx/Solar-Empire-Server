package com.podts.solarserver.entity;

import com.podts.solarserver.interfaces.HasName;
import com.podts.solarserver.ship.Ship;

public interface ShipOwner extends HasName {
	
	public Ship getShip();
	public void setShip(Ship s);
	
}
