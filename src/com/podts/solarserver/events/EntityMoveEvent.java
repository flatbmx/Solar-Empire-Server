package com.podts.solarserver.events;

import com.podts.solarserver.entity.Entity;
import com.podts.solarserver.event.Event;
import com.podts.solarserver.world.Location;

public class EntityMoveEvent extends Event {
	
	private final Entity entity;
	private Location location;
	
	public Entity getEntity() {
		return entity;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location l) {
		location = l;
	}
	
	public EntityMoveEvent(Entity e, Location l) {
		super("EntityMoveEvent");
		entity = e;
		location = l;
		if (e == null || l == null) {
			setCancelled(true);
		}
	}
	
	@Override
	public void execute() {
		
	}
	
}
