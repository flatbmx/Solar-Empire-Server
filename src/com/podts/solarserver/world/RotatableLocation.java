package com.podts.solarserver.world;

import com.podts.solarserver.network.PayLoad;

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
		if (Math.abs(getRotation()-getAngleDegrees(o)) <= error)
			return true;
		return false;
	}
	
	public boolean isFacing(Locatable o, double error) {
		if (o == null)
			return false;
		return isFacing(o.getLocation(),error);
	}
	
	@Override
	public void send(PayLoad payload) {
		super.send(payload);
		payload.writeDouble(rotation);
	}
	
	public RotatableLocation(double x, double y) {
		super(x, y);
	}
	
	public RotatableLocation(double x, double y, double r) {
		super(x, y);
		setRotation(r);
	}
	
	public RotatableLocation(double x, double y, Direction d) {
		super(x, y);
		if (d != null)
			setRotation(d.getRotation());
	}
	
	public static RotatableLocation receive(PayLoad payload) {
		try {
			return new RotatableLocation(payload.readDouble(),payload.readDouble(),payload.readDouble());
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
