package com.podts.solarserver.world;

import java.util.Collection;


public interface Dock extends Locatable {
	
	public Collection<Dockable> getObjects();
	
	public void dock(Dockable d);
	public void unDock(Dockable d);
	
	public Location getExit();
	
}
