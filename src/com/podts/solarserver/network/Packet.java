package com.podts.solarserver.network;

import java.io.IOException;
import java.util.HashMap;

import com.podts.solarserver.Server;




/**
 * Packet object that holds its opcode and payload.
 * @author David
 *
 */
public abstract class Packet {
	
	private static HashMap<Byte,Packet> packets = new HashMap<Byte, Packet>();
	
	public static void addPacket(Packet packet) {
		
		if (packet == null)
			return;
		
		packets.put(packet.getOpCode(), packet);
		
	}
	
	public static Packet getPacketFromId(byte id) {
		return packets.get(id);
	}
	
	private boolean recieved = false;
	
	/**
	 * The Stream that the packet came from, or is going to.
	 */
	private Stream stream;
	
	/**
	 * The packets opcode.
	 */
	private byte opcode = 0;
	
	/**
	 * The Packets payload.
	 */
	private PayLoad payload = new PayLoad();
	
	/**
	 * Returns the stream that the packet came from, or is going to.
	 * @return Stream
	 */
	public Stream getStream() {
		return stream;
	}
	
	public void setStream(Stream s) {
		stream = s;
	}
	
	/**
	 * Returns the packets opcode.
	 * @return the opcode.
	 */
	public byte getOpCode() {
		return opcode;
	}
	
	/**
	 * Returns the packets payload.
	 * @return the payload.
	 */
	public PayLoad getPayLoad() {
		return payload;
	}
	
	public boolean isRecieved() {
		return recieved;
	}
	
	public void sendPacket(Stream s) {
		this.stream = s;
		sendPacket();
	}
	
	private void sendPacket() {
		
		if (stream == null)
			return;
		
		if (opcode == 0)
			return;
		
		int size = 1;
		
		if (payload.getPayLoad().length > 0)
			size += payload.getPayLoad().length;
		
		try {
			getStream().writeInt(size);
			getStream().writeByte(opcode);
			if (payload.getPayLoad().length > 0)
				getStream().writeBytes(payload.getPayLoad());
			getStream().getOutstream().flush();
		} catch (IOException e) {
			Server.getServer().getLogger().info("Stream closed");
			try {
				getStream().eof();
			} catch (IOException e1) {
				
			}
		}
		
	}
	
	public static Packet readPacket(Stream s) {
		
		try {
			
			if (s.getInStream().available() > 0) {
				
				
				int size = s.readInt();
				
				if (size == 0)
					return null;
				
				Packet p;
				try {
					byte id = s.readByte();
					if (Packet.getPacketFromId(id) == null)
						return null;
					p = Packet.getPacketFromId(id).getClass().newInstance();
					p.opcode = id;
					p.stream = s;
				} catch (InstantiationException e) {
					e.printStackTrace();
					return null;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					return null;
				}
				
				if (size > 1)
					p.getPayLoad().construct(s, size-1);
				
				p.recieved = true;
				
				return p;
			}
			
		} catch (IOException e) {
			
			System.out.println("Stream closed!");
			
		}
		
		return null;
	}
	
	public abstract void handle();
	public abstract void generatepayload();
	
	public void send() {
		
		generatepayload();
		sendPacket();
		
	}
	
	public Packet(byte opcode) {
		this.opcode = opcode;
	}
	
	public Packet(byte opcode, Stream s) {
		this.stream = s;
		this.opcode = opcode;
	}
	
	public Packet(Stream s) {
		stream = s;
	}
	
}
