package com.podts.solarserver.network;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class PayLoad {
	
	/**
	 * The Packets current payload.
	 */
	private ArrayList<Byte> payload = new ArrayList<Byte>();
	
	/**
	 * Where the current pointer is reading/writing in the payload.
	 */
	private int pointer = 0;
	
	public void resetPointer() {
		pointer = 0;
	}
	
	public int getPointer() {
		
		return pointer;
		
	}
	
	public void construct(Stream s, int size) {
		
		for (int i=0; i<size; i++) {
			
			try {
				writeByte(s.readByte());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		pointer = 0;
		
	}
	
	/**
	 * Returns the payload as an array.
	 * @return The packets payload.
	 */
	public byte[] getPayLoad() {
		
		byte[] p = new byte[payload.size()];
		
		for (int index=0; index<p.length; index++)
			p[index] = payload.get(index);
		
		return p;
		
	}
	
	public byte readByte() {
		
		byte b = payload.get(pointer);
		pointer++;
		return b;
		
	}
	
	/**
	 * Write a byte to the payload.
	 * @param b - the byte to write.
	 */
	public void writeByte(byte b) {
		
		payload.add(b);
		pointer++;
		
	}
	
	/**
	 * Write an array of bytes to the payload.
	 * @param b - the array to write.
	 */
	public void writeBytes(byte[] b) {
		
		if (b == null)
			return;
		if (b.length <= 0)
			return;
		
		for (int index=0; index < b.length; index++)
			payload.add(b[index]);
		
		pointer += b.length;
		
	}
	
	public short readShort() {
		
		byte[] b = new byte[2];
		
		for (int index = 0; index < 2; index++ )
			b[index] = payload.get(index+pointer);
		
		pointer += 2;
		
		return ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).getShort();
		
	}
	
	public void writeShort(short s) {
		
		writeBytes(ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).putShort(s).array());
		
		pointer += 2;
		
	}
	
	/**
	 * Returns the next int from payload where the pointer is currently.
	 * @return int - the next int in the payload.
	 */
	public int readInt() {
		
		byte[] b = new byte[4];
		
		for (int index = 0; index < 4; index++ )
			b[index] = payload.get(index+pointer);
		
		pointer += 4;
		
		return ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).getInt();
		
	}
	
	/**
	 * Writes an int to the payload.
	 * @param i - the int to write.
	 */
	public void writeInt(int i) {
		
		writeBytes( ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array() );
		
		pointer += 4;
		
	}
	
	public float readFloat() {
		
		byte[] b = new byte[4];
		
		for (int index = 0; index < 4; index++ )
			b[index] = payload.get(index+pointer);
		
		pointer += 4;
		
		return ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).getFloat();
		
	}
	
	public void writeFloat(float f) {
		
		writeBytes( ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putFloat(f).array() );
		
		pointer += 4;
		
	}
	
	public long readLong() {
		
		byte[] b = new byte[8];
		
		for (int index = 0; index < 8; index++ )
			b[index] = payload.get(index+pointer);
		
		pointer += 8;
		
		return ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).getLong();
		
	}
	
	public void writeLong(long l) {
		
		writeBytes( ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN).putLong(l).array() );
		
		pointer += 8;
		
	}
	
	public void writeDouble(double d) {
		
		writeBytes( ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN).putDouble(d).array() );
		
		pointer += 8;
		
	}
	
	public double readDouble() {
		
		byte[] b = new byte[8];
		
		for (int index = 0; index < 8; index++ )
			b[index] = payload.get(index+pointer);
		
		pointer += 8;
		
		return ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).getDouble();
		
	}
	
	/**
	 * Returns a string that is in the payload.
	 * @return The String.
	 */
	public String readString() {
		
		short length = readShort();
		
		if (length <= 0)
			return null;
		
		byte[] b = new byte[length];
		
		for (int i=0; i<length; i++)
			b[i] = readByte();
		
		try {
			
			return new String(b,"UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return null;
			
		}
	}
	
	/**
	 * Writes a String to the payload.
	 * @param s - The String.
	 */
	public void writeString(String s) {
		
		byte[] b = null;
		
		try {
			
			b = s.getBytes("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			
		}
		
		if (b == null)
			return;
		
		writeShort((short) b.length);
		writeBytes(b);
		
	}
	
	public PayLoad() {
		
	}
	
	public PayLoad(byte[] b) {
		
		if (b == null)
			return;
		
		if (b.length <= 0)
			return;
		
		for (int i=0; i < b.length; i++)
			payload.add(b[i]);
		
	}
	
}
