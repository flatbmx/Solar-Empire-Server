package com.podts.solarserver.entity;

import com.podts.solarserver.Server;
import com.podts.solarserver.interfaces.Namable;
import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.Stream;
import com.podts.solarserver.network.packets.Packet_PlayNow;

public class Player implements Namable, Identifiable, Runnable {
	
	private Thread thread;
	private boolean loggedin;
	
	private String name;
	private int id;
	private Stream stream;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getID() {
		return id;
	}
	
	public Stream getStream() {
		return stream;
	}
	
	public Player(String username, Stream stream) {
		name = username;
		this.stream = stream;
		loggedin = true;
		thread = new Thread(this);
		thread.start();
		new Packet_PlayNow(stream).send();
	}

	@Override
	public void run() {
		while (Server.run && loggedin) {
			try {
				stream.ping();
				if (stream.isEOF()) {
					Server.getServer().getNetworkManager().getLogger().info(getName() + " disconnected.");
					break;
				}
				while (stream.getAvailable() > 0) {
					Packet packet = Packet.readPacket(stream);
					if (packet != null) {
						packet.handle();
					}
				}
			} catch (Exception e) {
				Server.getServer().getNetworkManager().getLogger().info(getName() + " disconnected.");
				break;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			
		}
	}
	
}
