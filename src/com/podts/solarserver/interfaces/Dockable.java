package com.podts.solarserver.interfaces;

public interface Dockable extends Hidable {
	
	public Dock getDock();
	
	public boolean isDocked();
	
	public void dock(Dock d);
	public void unDock();
	
}
