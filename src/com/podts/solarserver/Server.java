package com.podts.solarserver;

import java.util.logging.Logger;

import com.podts.solarserver.interfaces.Consolable;
import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.network.NetworkManager;
import com.podts.solarserver.world.Universe;

public class Server implements Namable, Consolable {
	
	private static Server instance;
	
	public static Server getServer() {
		if (instance == null)
			instance = new Server();
		return instance;
	}
	
	private String name;
	private Logger logger;
	private NetworkManager networkmanager;
	private Universe universe;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}
	
	public NetworkManager getNetworkManager() {
		return networkmanager;
	}
	
	public Universe getUniverse() {
		return universe;
	}
	
	private Server() {
		networkmanager = new NetworkManager();
		universe = new Universe("Uni");
	}
	
	public static void main(String[] args) {
		
		getServer();
		
	}
	
}
