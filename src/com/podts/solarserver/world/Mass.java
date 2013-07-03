package com.podts.solarserver.world;

public class Mass {
	
	private double volume, density;

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}
	
	public Mass(double volume, double density) {
		setVolume(volume);
		setDensity(density);
	}
	
}
