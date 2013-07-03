package com.podts.solarserver.entity;

import com.podts.solarserver.economy.Creditable;
import com.podts.solarserver.economy.Credits;
import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.network.Stream;
import com.podts.solarserver.world.Locatable;
import com.podts.solarserver.world.Location;

public class Player implements Namable, Locatable, ShipOwner, Creditable {
	
	private String name;
	private Stream stream;
	private Ship ship;
	private Credits credits;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public Stream getStream() {
		return stream;
	}
	
	@Override
	public Ship getShip() {
		return ship;
	}
	
	@Override
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	@Override
	public Location getLocation() {
		if (ship == null)
			return null;
		return ship.getLocation();
	}
	
	@Override
	public void setLocation(Location location) {
		if (ship != null)
			ship.setLocation(location);
	}
	
	@Override
	public Credits getCredits() {
		return credits;
	}

	@Override
	public void setCredits(Credits c) {
		credits = c;
	}
	
	public Player(UnVerifyedPlayer player) {
		if (player != null) {
			if (player.isVerifyed()) {
				this.stream = player.getStream();
			}
		}
	}
	
}
