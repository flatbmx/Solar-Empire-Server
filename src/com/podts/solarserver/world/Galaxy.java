package com.podts.solarserver.world;

import com.podts.solarserver.interfaces.HasName;

public class Galaxy implements HasName {
	
	private String name;
	
	@Override
	public String getName() {
		return name;
	}
	
	public Galaxy(String name) {
		this.name = name;
	}
	
}
