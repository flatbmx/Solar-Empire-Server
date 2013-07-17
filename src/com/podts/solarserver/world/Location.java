package com.podts.solarserver.world;

public class Location {
	
	public static final Location NOWHERE = null;
	
	private StarSystem system;
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

	public StarSystem getSystem() {
		return system;
	}

	public void setSystem(StarSystem system) {
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
	
	public boolean sameGalaxy(Location o) {
		if (system == null || o == NOWHERE || o.system == null)
			return false;
		if (system.getGalaxy() != null && o.system.getGalaxy() != null) {
			if (system.getGalaxy() == o.system.getGalaxy())
				return true;
		}
		return false;
	}
	
	public boolean sameGalaxy(Locatable o) {
		if (o == null)
			return false;
		return sameGalaxy(o.getLocation());
	}
	
	public boolean sameSystem(Location o) {
		if (system == null || o == NOWHERE || o.system == null)
			return false;
		return system == o.system;
	}
	
	public boolean sameSystem(Locatable o) {
		if (o == null)
			return false;
		return sameSystem(o.getLocation());
	}
	
	public double distance(Location o) {
		return Math.sqrt( (x-o.getX())*(x-o.getX()) + (y-o.getY())*(y-o.getY()) );
	}
	
	public double distance(Locatable o) {
		return distance(o.getLocation());
	}
	
	public double getAngleRads(Location o) {
		return Math.atan2(o.getX() - getX(), o.getY() - getY())-90;
	}
	
	public double getAngleRads(Locatable o) {
		return getAngleRads(o.getLocation());
	}
	
	public double getAngleDegrees(Location o) {
		return Math.toDegrees(getAngleRads(o));
	}
	
	public double getAngleDegrees(Locatable o) {
		return getAngleDegrees(o.getLocation());
	}
	
	public Location(StarSystem system, double x, double y) {
		setSystem(system);
		setX(x);
		setY(y);
	}
	
}
