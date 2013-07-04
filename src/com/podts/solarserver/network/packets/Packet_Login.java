package com.podts.solarserver.network.packets;

import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;

public class Packet_Login extends Packet {
	
	public static final byte RESPONSE_ACCEPT = 1, RESPONSE_DENY = 2;
	
	private float version;
	private byte response;
	private String username, password, responsemessage;
	
	public float getVersion() {
		return version;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public byte getResponseCode() {
		return response;
	}

	public void setResponseCode(byte response) {
		this.response = response;
	}

	public String getResponseMessage() {
		return responsemessage;
	}

	public void setResponseMessage(String response) {
		this.responsemessage = response;
	}

	@Override
	public void handle() {
		
		version = getPayLoad().readFloat();
		username = getPayLoad().readString();
		password = getPayLoad().readString();
		
		System.out.println(version+username+password);
		
	}

	@Override
	public void generatepayload() {
		getPayLoad().writeByte(getResponseCode());
		getPayLoad().writeString(getResponseMessage());
		if (getResponseCode() == RESPONSE_ACCEPT) {
			// Send the players id.
		}
	}
	
	public Packet_Login() {
		super(PacketType.LOGIN.getOpCode());
	}
	
}
