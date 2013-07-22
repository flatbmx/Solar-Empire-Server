package com.podts.solarserver.ship;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.podts.solarserver.communication.Alertable;
import com.podts.solarserver.entity.GravitableEntity;
import com.podts.solarserver.entity.ShipModel;
import com.podts.solarserver.entity.ShipOwner;
import com.podts.solarserver.world.Acceleratable;
import com.podts.solarserver.world.Dock;
import com.podts.solarserver.world.Dockable;
import com.podts.solarserver.world.Force;
import com.podts.solarserver.world.HasRotation;
import com.podts.solarserver.world.Hidable;
import com.podts.solarserver.world.Location;
import com.podts.solarserver.world.Rotatable;
import com.podts.solarserver.world.RotatableLocation;

public class Ship extends GravitableEntity implements Rotatable, Acceleratable, Dockable, Alertable {
	
	private Dock dock;
	private ShipOwner owner;
	private ShipModel model;
	
	private Map<String,ShipCategory> categories = new ConcurrentHashMap<String,ShipCategory>();
	
	public Collection<ShipCategory> getCategories() {
		return categories.values();
	}
	
	public ShipCategory getCategory(String category) {
		return categories.get(category);
	}
	
	public ShipOwner getOwner() {
		return owner;
	}
	
	public ShipModel getModel() {
		return model;
	}
	
	public Engines getEngines() {
		return (Engines) getCategory("Engines");
	}
	
	@Override
	public RotatableLocation getRotatableLocation() {
		return (RotatableLocation) getLocation();
	}
	
	@Override
	public void moveTo(Location l) {
		
	}

	@Override
	public void move(HasRotation r, Force f) {
		
	}

	@Override
	public Force getMaximumForce() {
		return getEngines().getMaximumForce();
	}
	
	@Override
	public void sendMessage(String message) {
		owner.sendMessage(message);
	}
	
	@Override
	public void sendAlert(String message) {
		owner.sendAlert(message);
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
	
	public Ship(ShipOwner owner, ShipModel model, RotatableLocation location) {
		super(location,model.getMass());
		this.owner = owner;
		this.model = model;
	}
	
}
