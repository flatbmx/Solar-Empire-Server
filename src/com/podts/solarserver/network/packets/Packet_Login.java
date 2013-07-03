package com.podts.solarserver.network.packets;

import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;

public class Packet_Login extends Packet {
	
	private float version;
	private String username, password;
	
	public float getVersion() {
		return version;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public void handle() {
		
		version = getPayLoad().readFloat();
		username = getPayLoad().readString();
		password = getPayLoad().readString();
		
	}

	@Override
	public void generatepayload() {
		
		
		
	}
	
	public Packet_Login() {
		super(PacketType.LOGIN.getOpCode());
	}
	
}
