package com.podts.solarserver.network.packets;

import com.podts.solarserver.entity.Entity;
import com.podts.solarserver.network.Packet;
import com.podts.solarserver.network.PacketType;
import com.podts.solarserver.network.Stream;
import com.podts.solarserver.world.Location;
import com.podts.solarserver.world.RotatableLocation;
import com.podts.solarserver.world.Velocity;

public class Packet_Entity extends Packet {
	
	public static final byte NEW_ENTITY = 1, UPDATE_ENTITY = 2, REMOVE_ENTITY = 3;
	
	private final Entity entity;
	private final byte action;
	
	public Packet_Entity(Entity e, byte action, Stream s) {
		super(PacketType.ENTITY.getOpCode());
		setStream(s);
		entity = e;
		this.action = action;
	}
	
	public Packet_Entity() {
		super(PacketType.ENTITY.getOpCode());
		entity = null;
		this.action = 0;
	}
	
	public Packet_Entity(Entity e, byte action) {
		super(PacketType.ENTITY.getOpCode());
		entity = e;
		this.action = action;
	}
	
	@Override
	public void handle() {
		// When a player moves.
		byte kind = getPayLoad().readByte();
		
		if (kind == UPDATE_ENTITY) {
			Location nl = RotatableLocation.receive(getPayLoad());
			Velocity nv = Velocity.receive(getPayLoad());
		}
	}

	@Override
	public void generatepayload() {
		
		if (entity == null)
			return;
		
		getPayLoad().writeInt(entity.getID());
		getPayLoad().writeByte(action);
		
		switch(action) {
		
			case NEW_ENTITY:
				// Send entity type
				getPayLoad().write(entity.getLocation());
				getPayLoad().write(entity.getVelocity());
				break;
			
			case UPDATE_ENTITY:
				getPayLoad().write(entity.getLocation());
				getPayLoad().write(entity.getVelocity());
				break;
		
		}
		
	}

}
