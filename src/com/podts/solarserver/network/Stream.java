package com.podts.solarserver.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import com.podts.solarserver.network.packets.Packet_Ping;

public class Stream {
	
	private Socket socket;
	private BufferedInputStream instream;
	private BufferedOutputStream outstream;
	private boolean eof;
	
	private long lastping = System.currentTimeMillis();
	
	public boolean isEOF() {
		return eof;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedInputStream getInStream() {
		return instream;
	}
	
	public void setInstream(BufferedInputStream instream) {
		this.instream = instream;
	}
	
	public BufferedOutputStream getOutstream() {
		return outstream;
	}
	
	public void setOutstream(BufferedOutputStream outstream) {
		this.outstream = outstream;
	}
	
	public void ping() throws IOException {
		
		if (lastping + 2000 > System.currentTimeMillis())
			return;
		
		lastping = System.currentTimeMillis();
		
		new Packet_Ping(this).send();
		
	}
	
	public void eof() throws IOException {
		
		eof = true;
		
		try {
			
			socket.close();
			
		} catch (IOException e) {
			
		}
		
		throw new IOException("Stream had to end.");
		
	}
	
	public String getIP() {
		
		byte[] ips = socket.getInetAddress().getAddress();
		String ip = "";
		ip = String.valueOf(ips[0]);
		ip = ip + "." + String.valueOf(ips[1]);
		ip = ip + "." + String.valueOf(ips[2]);
		ip = ip + "." + String.valueOf(ips[3]);
		return ip;
		
	}
	
	public void flush() throws IOException {
		
		try {
			
			getOutstream().flush();
			
		} catch (IOException e) {
			
			eof();
			
		}
		
	}
	
	public int getAvailable() throws IOException {
		try {
			return getInStream().available();
		} catch (IOException e) {
			eof();
		}
		return 0;
	}
	
	public byte readByte() throws IOException {
		
		try {
			
			byte[] b = new byte[1];
			
			instream.read(b);
			
			return b[0];
			
		} catch (IOException e) {
			
			eof();
			
		}
		
		return 0;
		
	}
	
	public byte[] readBytes(int size) throws IOException {
		
		try {
			
			if (instream.available() >= size) {
				
				byte[] bytes = new byte[size];
				
				getInStream().read(bytes);
				
				return bytes;
				
			}
			
		} catch (IOException e) {
			
			eof();
			
		}
		return null;
		
	}
	
	public void writeByte(byte b) throws IOException {
		
		try {
			
			byte[] bytes = new byte[1];
			bytes[0] = b;
			
			outstream.write(bytes);
			
		} catch (IOException e) {
			
			eof();
			
		}
		
	}
	
	public void writeBytes(byte[] bytes) throws IOException {
		
		
		try {
			
			getOutstream().write(bytes);
			
		} catch (IOException e) {
			
			eof();
			
		}
		
	}
	
	public int readInt() throws IOException {
		
		try {
			
			byte[] b = new byte[4];
			
			instream.read(b);
			
			PayLoad p = new PayLoad();
			p.writeBytes(b);
			p.resetPointer();
			return p.readInt();
			
		} catch (IOException e) {
			
			eof();
			
		}
		
		return 0;
		
	}
	
	public void writeInt(int i) throws IOException {
		
		try {
			
			PayLoad p = new PayLoad();
			p.writeInt(i);
			outstream.write(p.getPayLoad());
			
		} catch (IOException e) {
			
			eof();
			
		}
		
	}
	
	public Packet constructPacket() {
		try {
			
			if (getInStream().available() > 0) {
				
				// Something in the stream that has not been read.
				
			}
			
		} catch (IOException e) {
			
			try {
				
				eof();
				
			} catch (IOException e1) {
				
			}
			
		}
		return null;
	}
	
	public void compress(byte[] data) throws IOException {
		Deflater d = new Deflater();
		DeflaterOutputStream dout = new DeflaterOutputStream(getOutstream(), d);
		dout.write(data);
		dout.close();
	}
	
	public byte[] decompress() throws IOException {
		InflaterInputStream in = new InflaterInputStream(getInStream());
		ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
		int b;
		while ((b = in.read()) != -1) {
			bout.write(b);
		}
		in.close();
		bout.close();
		return bout.toByteArray();
	}
	
	/**
	 * Creates a stream object that is bound by the socket given.
	 * @param socket - The Socket that the stream will be built off of.
	 * @throws IOException If there is an issue creating the stream.
	 */
	public Stream(Socket socket) throws IOException {
		
		setSocket(socket);
		setInstream(new BufferedInputStream(socket.getInputStream()));
		setOutstream(new BufferedOutputStream(socket.getOutputStream()));
		
	}
	
}

