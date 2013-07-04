package com.podts.solarserver.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Logger;

import com.podts.solarserver.Server;
import com.podts.solarserver.console.GameLogger;
import com.podts.solarserver.entity.UnVerifyedPlayer;
import com.podts.solarserver.interfaces.Consolable;

public class NetworkManager implements Runnable, Consolable {
	
	private ServerSocket listensocket;
	private Logger logger = new GameLogger("Network");
	
	public void run() {
		
		while(Server.run) {
			try {
				Socket temp = listensocket.accept();
				if (temp != null) {
					System.out.println(temp.getInetAddress().toString());
					new UnVerifyedPlayer(new Stream(temp));
				}
			} catch (IOException e) {
				if (!(e instanceof SocketTimeoutException))
					e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}
	
	public NetworkManager() {
		try {
			listensocket = new ServerSocket(5000);
			listensocket.setSoTimeout(100);
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
			getLogger().warning("Error initializing network manager.");
		}
	}
	
}
