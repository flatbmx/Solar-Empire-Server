package com.podts.solarserver.world;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.podts.solarserver.interfaces.HasName;

public class Universe implements HasName {
	
	private String name;
	private Map<String,Galaxy> galaxys = new ConcurrentHashMap<String,Galaxy>();
	
	@Override
	public String getName() {
		return name;
	}
	
	public Collection<Galaxy> getGalaxys() {
		return galaxys.values();
	}
	
	public void addGalaxy(Galaxy g) {
		galaxys.put(g.getName(), g);
	}
	
	public void removeGalaxy(Galaxy g) {
		galaxys.remove(g.getName());
	}
	
	public Universe(String name) {
		this.name = name;
	}
	
}
