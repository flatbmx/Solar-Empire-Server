package com.podts.solarserver.world;

import com.podts.solarserver.network.PayLoad;
import com.podts.solarserver.network.Sendable;

public class Velocity implements Sendable {
	
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
	
	public Velocity() {
		
	}
	
	@Override
	public void send(PayLoad payload) {
		
		payload.writeDouble(x);
		payload.writeDouble(y);
		
	}
	
	public Velocity(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public static Velocity receive(PayLoad payload) {
		try {
			return new Velocity(payload.readDouble(),payload.readDouble());
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
