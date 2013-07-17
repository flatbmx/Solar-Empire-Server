package com.podts.solarserver.world;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.podts.solarserver.RecycledIntList;
import com.podts.solarserver.entity.Identifiable;
import com.podts.solarserver.interfaces.HasName;

public class Galaxy implements HasName, Identifiable {
	
	private static RecycledIntList ids = new RecycledIntList();
	
	private String name;
	private int id;
	private Universe universe;
	private Map<String,StarSystem> systems = new ConcurrentHashMap<String,StarSystem>();
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getID() {
		return id;
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
	
	public Collection<StarSystem> getSystems() {
		return systems.values();
	}
	
	public StarSystem getSystem(String name) {
		return systems.get(name);
	}
	
	public void addSystem(StarSystem s) {
		systems.put(s.getName(), s);
	}
	
	public void removeSystem(StarSystem s) {
		systems.remove(s.getName());
	}
	
	public Galaxy(String name) {
		this.name = name;
		id = ids.getID();
	}
	
}
