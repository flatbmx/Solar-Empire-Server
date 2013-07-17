package com.podts.solarserver.world;

import java.util.Map;

import org.jnbt.Tag;

import com.podts.solarserver.RecycledIntList;
import com.podts.solarserver.entity.Identifiable;
import com.podts.solarserver.filesystem.Writable;
import com.podts.solarserver.interfaces.HasName;

public class StarSystem implements HasName, Identifiable, Writable {
	
	private static RecycledIntList ids = new RecycledIntList();
	
	private String name;
	private int id;
	private Galaxy galaxy;
	private double radius;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getID() {
		return id;
	}
	
	public Galaxy getGalaxy() {
		return galaxy;
	}

	public void setGalaxy(Galaxy galaxy) {
		if (this.galaxy != null)
			this.galaxy.removeSystem(this);
		this.galaxy = galaxy;
		this.galaxy.addSystem(this);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public boolean save() {
		return true;
	}

	@Override
	public boolean write(Map<String, Tag> m) {
		return true;
	}
	
	public StarSystem(String name) {
		this.name = name;
		radius = 5000;
	}
	
	public StarSystem(String name, double radius) {
		id = ids.getID();
		this.name = name;
		this.radius = radius;
	}
	
}
