package com.podts.solarserver.entity;

import com.podts.solarserver.economy.Creditable;
import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.network.Stream;
import com.podts.solarserver.world.Locatable;
import com.podts.solarserver.world.Location;

public class Player implements Namable, Locatable, Creditable {
	
	private String name;
	private Stream stream;
	private Ship ship;
	private long credits, maxcredits = 100000000;
	
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
	
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public Location getLocation() {
		if (ship == null)
			return null;
		return ship.getLocation();
	}
	
	public void setLocation(Location location) {
		if (ship != null)
			ship.setLocation(location);
	}
	
	@Override
	public long getCredits() {
		return credits;
	}
	
	@Override
	public long getMaximumCredits() {
		return maxcredits;
	}
	
	@Override
	public void setCredits(long credits) {
		this.credits = credits;
	}

	@Override
	public boolean hasCredits(long credits) {
		return this.credits >= credits;
	}

	@Override
	public void takeCredits(long credits) {
		this.credits -= credits;
	}

	@Override
	public void giveCredits(long credits) {
		this.credits += credits;
	}
	
	public Player(UnVerifyedPlayer player) {
		if (player != null) {
			if (player.isVerifyed()) {
				this.stream = player.getStream();
			}
		}
	}
	
}
