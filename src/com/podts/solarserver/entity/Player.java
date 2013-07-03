package com.podts.solarserver.entity;

import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.network.Stream;

public class Player implements Namable {
	
	private String name;
	private Stream stream;
	private Ship ship;
	
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

	public Player(UnVerifyedPlayer player) {
		if (player != null) {
			if (player.isVerifyed()) {
				this.stream = player.getStream();
			}
		}
	}
	
}
