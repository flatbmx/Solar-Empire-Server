package com.podts.solarserver.interfaces;

import com.podts.solarserver.world.Locatable;

public interface Hidable extends Locatable {
	
	public boolean isHidden(Hidable h);
	
}
