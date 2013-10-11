package com.podts.solarserver.communication;

public interface Alertable extends Messagable {
	
	public void sendAlert(String message);
	
}
