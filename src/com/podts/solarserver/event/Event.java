package com.podts.solarserver.event;

import com.podts.solarserver.interfaces.HasName;

public abstract class Event implements HasName {
	
	final private String name;
	private boolean cancel = false;
	
	@Override
	public String getName() {
		return name;
	}
	
	public boolean isCancelled() {
		return cancel;
	}
	
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
	
	public abstract void execute();
	
	public void fire() {
		
		if (cancel)
			return;
		
	}
	
	public Event(String name) {
		this.name = name;
	}
	
}
