package com.podts.solarserver.network.packets;

import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;
import com.podts.solarserver.network.Stream;

public class Packet_World extends Packet {

	public Packet_World(Stream s) {
		super(PacketType.WORLD.getOpCode());
		setStream(s);
	}
	
	public Packet_World() {
		super(PacketType.WORLD.getOpCode());
	}
	
	@Override
	public void handle() {
		
	}

	@Override
	public void generatepayload() {
		
		
		
	}

}
