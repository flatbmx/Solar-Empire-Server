package com.podts.solarserver.world;

import com.podts.solarserver.network.PayLoad;
import com.podts.solarserver.network.Sendable;

public class Location implements Sendable {
	
	public static final Location NOWHERE = null;
	
	private volatile double x, y;
	private Chunk chunk;

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
	
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public Chunk getChunk() {
		return chunk;
	}
	
	public void setChunk(Chunk c) {
		if (c != null)
			chunk = c;
	}
	
	public void shift(Location location) {
		if (location == null)
			return;
		setX(getX() + location.getX());
		setY(getY() + location.getY());
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
	
	public Location(double x, double y) {
		setX(x);
		setY(y);
	}

	@Override
	public void send(PayLoad payload) {
		
		payload.writeDouble(x);
		payload.writeDouble(y);
		
	}
	
}
