package com.podts.solarserver;

import com.podts.solarserver.world.Universe;

public class Server {
	
	private static Server instance;
	
	public static Server getServer() {
		if (instance == null)
			instance = new Server();
		return instance;
	}
	
	private Universe universe;
	
	public Universe getUniverse() {
		return universe;
	}
	
	private Server() {
		universe = new Universe("Uni");
	}
	
	public static void main(String[] args) {
		
		getServer();
		
	}
	
}
