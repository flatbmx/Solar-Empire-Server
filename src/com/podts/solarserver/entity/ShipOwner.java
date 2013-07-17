package com.podts.solarserver.entity;

import com.podts.solarserver.communication.Alertable;
import com.podts.solarserver.interfaces.HasName;
import com.podts.solarserver.ship.Ship;

public interface ShipOwner extends HasName, Alertable {
	
	public Ship getShip();
	public void setShip(Ship s);
	
}
