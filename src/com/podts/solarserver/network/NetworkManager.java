package com.podts.solarserver.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.podts.solarserver.Server;
import com.podts.solarserver.entity.UnVerifyedPlayer;

public class NetworkManager implements Runnable {
	
	private ServerSocket listensocket;
	
	public void run() {
		
		Socket temp;
		
		while(Server.run) {
			try {
				temp = listensocket.accept();
				if (temp != null) {
					temp.setTcpNoDelay(true);
					temp.setPerformancePreferences(0, 2, 1);
					Stream s = new Stream(temp);
					new UnVerifyedPlayer(s);
				}
			} catch (Exception e) {
				
			}
		}
		
	}
	
	public NetworkManager() {
		try {
			listensocket = new ServerSocket(5000);
			listensocket.setSoTimeout(100);
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
