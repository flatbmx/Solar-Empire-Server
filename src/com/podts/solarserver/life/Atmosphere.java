package com.podts.solarserver.life;

import com.podts.solarserver.Util;

public class Atmosphere {
	
	private double temperature, pressure;
	private double toxicity;
	
	public boolean isSafe() {
		if (!Util.between(temperature,50,100))
			return false;
		if (!Util.between(pressure,0,7))
			return false;
		if (!Util.between(toxicity,0,100))
			return false;
		return true;
	}
	
}
