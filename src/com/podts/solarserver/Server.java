package com.podts.solarserver;

public class Server {
	
	private static Server instance;
	
	public static Server getServer() {
		if (instance == null)
			instance = new Server();
		return instance;
	}
	
	public static void main(String[] args) {
		
		getServer();
		
	}
	
	private Server() {
		
	}
	
}
