package com.podts.solarserver.network;

import java.io.IOException;
import java.net.ServerSocket;

import com.podts.solarserver.Server;

public class NetworkManager implements Runnable {
	
	private ServerSocket listensocket;
	
	public void run() {
		
		while(Server.run) {
			
			
			
		}
		
	}
	
	public NetworkManager() {
		try {
			listensocket = new ServerSocket(5000);
			listensocket.setSoTimeout(100);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
