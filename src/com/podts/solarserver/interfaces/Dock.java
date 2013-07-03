package com.podts.solarserver.interfaces;

import java.util.Collection;

import com.podts.solarserver.world.Locatable;
import com.podts.solarserver.world.Location;

public interface Dock extends Locatable {
	
	public Collection<Dockable> getObjects();
	
	public void dock(Dockable d);
	public void unDock(Dockable d);
	
	public Location getExit();
	
}
