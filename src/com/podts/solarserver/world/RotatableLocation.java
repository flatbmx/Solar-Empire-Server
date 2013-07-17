package com.podts.solarserver.world;

public class RotatableLocation extends Location implements HasRotation {
	
	private volatile double rotation;
	
	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	
	public void rotate(double angle) {
		rotation += angle;
		rotation %= 360;
	}
	
	public void face(Location o) {
		rotation = getAngleDegrees(o);
	}
	
	public void face(Locatable o) {
		face(o.getLocation());
	}
	
	public boolean isFacing(Location o) {
		return isFacing(o,10);
	}
	
	public boolean isFacing(Locatable o) {
		if (o == null)
			return false;
		return isFacing(o.getLocation());
	}
	
	public boolean isFacing(Direction d) {
		return isFacing(d,15);
	}
	
	public boolean isFacing(Direction d, double error) {
		return Math.abs(getRotation()-d.getRotation()) < error;
	}
	
	public boolean isFacing(Location o, double error) {
		if (o == null)
			return false;
		if (sameSystem(o)) {
			if (Math.abs(getRotation()-getAngleDegrees(o)) <= error)
				return true;
		}
		return false;
	}
	
	public boolean isFacing(Locatable o, double error) {
		if (o == null)
			return false;
		return isFacing(o.getLocation(),error);
	}
	
	public RotatableLocation(StarSystem system, double x, double y) {
		super(system, x, y);
	}
	
	public RotatableLocation(StarSystem system, double x, double y, double r) {
		super(system, x, y);
		setRotation(r);
	}
	
	public RotatableLocation(StarSystem system, double x, double y, Direction d) {
		super(system, x, y);
		if (d != null)
			setRotation(d.getRotation());
	}
	
}
