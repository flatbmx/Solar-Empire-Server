package com.podts.solarserver.network.packets;

import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;
import com.podts.solarserver.network.Stream;

public class Packet_Ping extends Packet {
	
	private int fps;
	
	public int getFPS() {
		return fps;
	}
	
	public Packet_Ping(Stream s) {
		super(PacketType.PING.getOpCode());
		setStream(s);
	}

	@Override
	public void handle() {
		fps = getPayLoad().readInt();
	}

	@Override
	public void generatepayload() {
		
	}

}
