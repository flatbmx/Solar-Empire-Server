package com.podts.solarserver.network;

import com.podts.solarserver.Util;

public enum PacketType {
	
	LOGIN((byte)1);
	
	private byte opcode;
	
	public String getName() {
		return toString();
	}
	
	@Override
	public String toString() {
		return Util.titleCase(super.toString().replace("_", " ")).replace(" ", "");
	}
	
	public byte getOpCode() {
		return opcode;
	}
	
	@SuppressWarnings("unchecked")
	public Packet getNewInstance() {
		
		Class<Packet> packetclass;
		
		try {
			getClass().getClassLoader().loadClass("com.podts.solarserver.network.packets.Packet_" + getName());
		} catch (ClassNotFoundException e1) {
			System.out.println("Could not load packet class");
			return null;
		}
		
		try {
			packetclass = (Class<Packet>) Class.forName("com.podts.solarserver.network.packets.Packet_" + getName());
		} catch (ClassNotFoundException e) {
			System.out.println("could not find packet class");
			return null;
		}
		
		try {
			return (Packet) packetclass.newInstance();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	PacketType(byte opcode) {
		this.opcode = opcode;
	}
	
}
