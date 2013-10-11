package com.podts.solarserver.entity;

import com.podts.solarserver.Server;
import com.podts.solarserver.economy.Creditable;
import com.podts.solarserver.economy.Credits;
import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.network.Stream;
import com.podts.solarserver.network.packets.Packet_PlayNow;
import com.podts.solarserver.ship.Ship;
import com.podts.solarserver.world.Location;
import com.podts.solarserver.world.Rotatable;
import com.podts.solarserver.world.RotatableLocation;

public class Player implements Namable, Rotatable, ShipOwner, Creditable, Identifiable {
	
	private String name;
	private int id;
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
	
	@Override
	public int getID() {
		return id;
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
	public RotatableLocation getRotatableLocation() {
		if (ship == null)
			return null;
		return (RotatableLocation) getLocation();
	}
	
	@Override
	public void setLocation(Location location) {
		if (ship != null)
			ship.setLocation(location);
	}
	
	@Override
	public void sendMessage(String message) {
		
	}
	
	@Override
	public void sendAlert(String message) {
		
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
				Server.getServer().getLogger().info("sending playnow packet");
				new Packet_PlayNow(stream).send();
			}
		}
	}
	
}
