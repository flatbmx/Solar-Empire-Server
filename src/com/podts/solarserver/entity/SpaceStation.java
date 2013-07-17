package com.podts.solarserver.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.podts.solarserver.economy.Creditable;
import com.podts.solarserver.economy.Credits;
import com.podts.solarserver.world.Dock;
import com.podts.solarserver.world.Dockable;
import com.podts.solarserver.world.Location;
import com.podts.solarserver.world.Mass;

public class SpaceStation extends GravitableEntity implements Dock, Creditable {
	
	private List<Dockable> docked;
	private Credits credits;
	
	@Override
	public Collection<Dockable> getObjects() {
		return docked;
	}

	@Override
	public void dock(Dockable d) {
		
	}

	@Override
	public void unDock(Dockable d) {
		
	}

	@Override
	public Location getExit() {
		return null;
	}
	
	@Override
	public int getMaxCapacity() {
		return docked.size();
	}
	
	@Override
	public Credits getCredits() {
		return credits;
	}

	@Override
	public void setCredits(Credits c) {
		credits = c;
	}
	
	public SpaceStation(String name, Location location, Mass m) {
		super(location, m);
		setName(name);
	}
	
	public SpaceStation(String name, Location location, Mass m, int max) {
		super(location, m);
		setName(name);
		docked = new ArrayList<Dockable>(max);
	}
	
}
