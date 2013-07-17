package com.podts.solarserver.filesystem;

import java.util.Map;

import org.jnbt.Tag;

public interface Writable extends Savable {
	
	public boolean write(Map<String,Tag> m);
	
}
