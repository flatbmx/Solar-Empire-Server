package com.podts.solarserver.world;

import java.util.Collection;

import com.podts.solarserver.interfaces.HasName;


public interface Dock extends Locatable, HasName {
	
	public Collection<Dockable> getObjects();
	
	public int getMaxCapacity();
	
	public void dock(Dockable d);
	public void unDock(Dockable d);
	
	public Location getExit();
	
}
