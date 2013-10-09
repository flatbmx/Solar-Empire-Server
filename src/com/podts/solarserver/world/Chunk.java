package com.podts.solarserver.world;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.podts.solarserver.entity.Entity;

public class Chunk {
	
	public final static int CHUNK_SIZE = 10000;
	
	private final int x, y;
	private Map<Integer,Entity> entitys = new ConcurrentHashMap<Integer,Entity>();
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Collection<Entity> getEntitys() {
		return entitys.values();
	}
	
	public void addEntity(Entity e) {
		if (e == null)
			return;
		entitys.put(e.getID(), e);
	}
	
	public void removeEntity(Entity e) {
		if (e == null)
			return;
		entitys.remove(e.getID());
	}
	
	public boolean containsEntity(Entity e) {
		if (e == null)
			return false;
		return entitys.containsKey(e.getID());
	}
	
	public Chunk(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
