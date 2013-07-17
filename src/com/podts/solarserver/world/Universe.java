package com.podts.solarserver.world;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jnbt.Tag;

import com.podts.solarserver.filesystem.Writable;
import com.podts.solarserver.interfaces.HasName;

public class Universe implements HasName, Writable {
	
	public StarSystem startingsys;
	
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
	
	@Override
	public boolean save() {
		return true;
	}
	
	@Override
	public boolean write(Map<String,Tag> m) {
		return true;
	}
	
	public Universe(String name) {
		this.name = name;
		Galaxy g = new Galaxy("Milky Way");
		StarSystem sol = new StarSystem("Sol");
		g.addSystem(sol);
		g.addSystem(new StarSystem("Alpha Centauri"));
		addGalaxy(g);
		addGalaxy(new Galaxy("Andromida"));
		
		startingsys = sol;
		
	}
	
}
