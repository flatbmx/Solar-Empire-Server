package com.podts.solarserver.world;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.podts.solarserver.interfaces.HasName;

public class Galaxy implements HasName {
	
	private String name;
	private Universe universe;
	private Map<String,System> systems = new ConcurrentHashMap<String,System>();
	
	@Override
	public String getName() {
		return name;
	}
	
	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		if (this.universe != null)
			universe.removeGalaxy(this);
		this.universe = universe;
		universe.addGalaxy(this);
	}
	
	public Collection<System> getSystems() {
		return systems.values();
	}
	
	public void addSystem(System s) {
		systems.put(s.getName(), s);
	}
	
	public void removeSystem(System s) {
		systems.remove(s.getName());
	}
	
	public Galaxy(String name) {
		this.name = name;
	}
	
}
