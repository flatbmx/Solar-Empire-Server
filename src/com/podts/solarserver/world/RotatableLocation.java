package com.podts.solarserver.world;

public class RotatableLocation extends Location {
	
	public static final double DIRECTION_UP = 0, DIRECTION_RIGHT = 90, DIRECTION_DOWN = 180, DIRECTION_LEFT = 270;
	
	private double rotation;
	
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
		rotation = getAngleRads(o);
	}
	
	public void face(Locatable o) {
		face(o.getLocation());
	}
	
	public boolean isFacing(Location o) {
		return isFacing(o,15);
	}
	
	public boolean isFacing(Locatable o) {
		if (o == null)
			return false;
		return isFacing(o.getLocation());
	}
	
	public boolean isFacing(Location o, double offset) {
		if (o == null)
			return false;
		if (sameSystem(o)) {
			if (Math.abs(getRotation()-getAngleDegrees(o)) <= offset)
				return true;
		}
		return false;
	}
	
	public boolean isFacing(Locatable o, double offset) {
		if (o == null)
			return false;
		return isFacing(o.getLocation(),offset);
	}
	
	public RotatableLocation(StarSystem system, double x, double y) {
		super(system, x, y);
	}
	
	public RotatableLocation(StarSystem system, double x, double y, double r) {
		super(system, x, y);
		setRotation(r);
	}

}
