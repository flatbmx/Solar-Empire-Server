package com.podts.solarserver.world;

public class Location {
	
	public static final Location NOWHERE = null;
	
	private System system;
	private double x, y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
	
	public boolean isInGalaxy(Galaxy g) {
		if (g == null)
			return false;
		if (system == null)
			return false;
		if (system.getGalaxy() == null)
			return false;
		return g.getName().equals(system.getGalaxy().getName());
	}
	
	public double distance(Location o) {
		return Math.sqrt( (x-o.getX())*(x-o.getX()) + (y-o.getY())*(y-o.getY()) );
	}
	
	public double distance(Locatable o) {
		return Math.sqrt( (x-o.getLocation().getX())*(x-o.getLocation().getX()) + (y-o.getLocation().getY())*(y-o.getLocation().getY()) );
	}
	
	public double getAngleRads(Location o) {
		return Math.atan2(o.getX() - getX(), o.getY() - getY());
	}
	
	public double getAngleRads(Locatable o) {
		return Math.atan2(o.getLocation().getX() - getX(), o.getLocation().getY() - getY());
	}
	
	public double getAngleDegrees(Location o) {
		return Math.toDegrees(getAngleRads(o));
	}
	
	public double getAngleDegrees(Locatable o) {
		return Math.toDegrees(getAngleRads(o));
	}
	
	public Location(System system, double x, double y) {
		setSystem(system);
		setX(x);
		setY(y);
	}
	
}
