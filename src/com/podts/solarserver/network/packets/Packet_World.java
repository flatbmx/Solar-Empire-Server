package com.podts.solarserver.network.packets;

import com.podts.solarserver.Server;
import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;
import com.podts.solarserver.network.Stream;
import com.podts.solarserver.world.Galaxy;
import com.podts.solarserver.world.StarSystem;

public class Packet_World extends Packet {

	public Packet_World(Stream s) {
		super(PacketType.WORLD.getOpCode());
		setStream(s);
	}

	@Override
	public void handle() {
		
	}

	@Override
	public void generatepayload() {
		
		getPayLoad().writeString(Server.getServer().getUniverse().getName());
		
		int gnumber = Server.getServer().getUniverse().getGalaxys().size();
		
		getPayLoad().writeInt(gnumber);
		
		if (gnumber > 0) {
			
			for (Galaxy g : Server.getServer().getUniverse().getGalaxys()) {
				
				getPayLoad().writeString(g.getName());
				
				short snumber = (short)g.getSystems().size();
				
				getPayLoad().writeShort(snumber);
				
				if (snumber > 0) {
					
					for (StarSystem s : g.getSystems()) {
						
						getPayLoad().writeString(s.getName());
						
					}
					
				}
				
			}
			
		}
		
	}

}
