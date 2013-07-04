package com.podts.solarserver.entity;

import com.podts.solarserver.Server;
import com.podts.solarserver.interfaces.HasName;
import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.Stream;

public class UnVerifyedPlayer implements HasName, Runnable {
	
	private boolean verifyed;
	private Stream stream;
	private String name;
	
	public boolean isVerifyed() {
		return verifyed;
	}
	
	public Stream getStream() {
		return stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public UnVerifyedPlayer(Stream stream) {
		setStream(stream);
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (Server.run) {
			try {
				stream.ping();
				if (stream.isEOF()) {
					break;
				}
				while (stream.getAvailable() > 0) {
					Packet packet = Packet.readPacket(stream);
					if (packet != null) {
						packet.handle();
					}
				}
			} catch (Exception e) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
		}
		System.out.println("Lost A Connection");
	}
	
}
