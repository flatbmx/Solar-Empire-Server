package com.podts.solarserver.world;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jnbt.Tag;

import com.podts.solarserver.filesystem.Writable;
import com.podts.solarserver.interfaces.HasName;

public class Universe implements HasName, Writable {
	
	private String name;
	private Map<String,Chunk> chunks = new ConcurrentHashMap<String,Chunk>();
	
	@Override
	public String getName() {
		return name;
	}
	
	public Collection<Chunk> getChunks() {
		return chunks.values();
	}
	
	public Chunk getChunkByLocation(Location l) {
		if (l == null)
			return null;
		int x = (int) (l.getX()/Chunk.CHUNK_SIZE);
		int y = (int) (l.getY()/Chunk.CHUNK_SIZE);
		
		Chunk c = chunks.get(x + "," + y);
		if (c == null) {
			c = new Chunk(x,y);
			chunks.put(x + "" + y, c);
		}
		
		return c;
	}
	
	public Chunk getChunk(int x, int y) {
		return chunks.get(x + "," + y);
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
	}
	
}
