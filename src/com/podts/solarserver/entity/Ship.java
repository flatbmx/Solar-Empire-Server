package com.podts.solarserver.entity;

import com.podts.solarserver.world.Dock;
import com.podts.solarserver.world.Dockable;
import com.podts.solarserver.world.Hidable;
import com.podts.solarserver.world.Location;

public class Ship extends Entity implements Dockable {
	
	private Dock dock;
	private ShipOwner owner;
	private ShipModel model;
	
	public ShipOwner getOwner() {
		return owner;
	}
	
	public ShipModel getModel() {
		return model;
	}
	
	@Override
	public boolean isHidden(Hidable h) {
		if (getLocation().equals(Location.NOWHERE) || h.getLocation().equals(Location.NOWHERE))
			return true;
		if (getLocation().getSystem() != h.getLocation().getSystem())
			return true;
		if (!(h instanceof Dockable) && isDocked())
			return true;
		if (!getDock().equals(((Dockable)h).getDock()))
			return true;
		return false;
	}
	
	@Override
	public Dock getDock() {
		return dock;
	}

	@Override
	public boolean isDocked() {
		return dock != null;
	}

	@Override
	public void dock(Dock d) {
		dock = d;
	}

	@Override
	public void unDock() {
		dock = null;
	}
	
	public Ship(ShipOwner owner, ShipModel model, Location location) {
		super(location);
		this.owner = owner;
		this.model = model;
	}
	
}
