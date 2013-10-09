package com.podts.solarserver.network.packets;

import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;
import com.podts.solarserver.network.Stream;

public class Packet_PlayNow extends Packet {

	public Packet_PlayNow(Stream s) {
		super(PacketType.PLAYNOW.getOpCode());
		setStream(s);
	}
	
	public Packet_PlayNow() {
		super(PacketType.PLAYNOW.getOpCode());
	}

	@Override
	public void handle() {
		
	}

	@Override
	public void generatepayload() {
		
	}

}
