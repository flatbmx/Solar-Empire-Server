package com.podts.solarserver.console;

import java.io.IOException;
import java.util.Scanner;

import org.fusesource.jansi.AnsiConsole;

import com.podts.solarserver.Server;

import jline.ConsoleReader;
import jline.Terminal;

public class Console implements Runnable {
	
	private static Terminal terminal;
	private static boolean useJline = true;
	
	private static Scanner scanner;
	
	public static void setJline(boolean use) {
		useJline = use;
	}
	
	private static ConsoleReader reader;
	
	public static ConsoleReader getReader() {
		return reader;
	}
	
	private static boolean debugmode = false;
	
	public static Terminal getTerminal() {
		return terminal;
	}
	
	public static void setTerminal(Terminal term) {
		terminal = term;
	}
	
	public static boolean getDebugMode() {
		return debugmode;
	}
	
	public static void setDebugMode(boolean ans) {
		debugmode = ans;
	}
	
	public Console() {
		AnsiConsole.systemInstall();
		if (useJline) {
			try {
				Terminal term = Terminal.getTerminal();
				if (!term.isSupported()) {
					useJline = false;
					return;
				}
				Console.setTerminal(term);
				reader = new ConsoleReader();
				reader.setBellEnabled(false);
				reader.setDefaultPrompt(">");
			} catch (IOException e) {
				useJline = false;
			}
		}
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		while (Server.run) {
			String input = null;
			try {
				if (useJline)
					input = reader.readLine();
				else {
					scanner = new Scanner(System.in);
					input = scanner.next();
				}
			} catch (IOException e) {
				Server.getServer().getLogger().info("Could not handle line!");
			}

			if (input != null) {
				if (input.equalsIgnoreCase("stop")) {
					if (scanner != null)
						scanner.close();
					Server.run = false;
				}
			}
		}
		
	}
	
}
