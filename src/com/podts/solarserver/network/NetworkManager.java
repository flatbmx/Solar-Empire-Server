package com.podts.solarserver.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import com.podts.solarserver.Server;
import com.podts.solarserver.entity.UnVerifyedPlayer;

public class NetworkManager implements Runnable {
	
	private ServerSocket listensocket;
	
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
	
	public NetworkManager() {
		try {
			listensocket = new ServerSocket(5000);
			listensocket.setSoTimeout(100);
			new Thread(this).start();
		} catch (IOException e) {
			System.out.println("error");
		}
	}
	
}
