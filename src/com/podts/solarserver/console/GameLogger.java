package com.podts.solarserver.console;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameLogger extends Logger {
	
	@Override
	public void finest(String s) {
		checkLevel();
		super.finest(s);
		redrawInput();
	}
	
	@Override
	public void finer(String s) {
		checkLevel();
		super.finer(s);
		redrawInput();
	}
	
	@Override
	public void fine(String s) {
		checkLevel();
		super.fine(s);
		redrawInput();
	}
	
	@Override
	public void info(String s) {
		checkLevel();
		super.info(s);
		redrawInput();
	}
	
	@Override
	public void warning(String s) {
		checkLevel();
		super.warning(s);
		redrawInput();
	}
	
	@Override
	public void severe(String s) {
		checkLevel();
		super.severe(s);
		redrawInput();
	}
	
	private void checkLevel() {
		if (Console.getDebugMode())
			setLevel(Level.ALL);
		else
			setLevel(Level.INFO);
	}
	
	private void redrawInput() {
		if (Console.getReader() != null) {
			try {
				Console.getReader().redrawLine();
				Console.getReader().flushConsole();
			} catch (IOException e) {
			
			}
		}
	}
	
	public GameLogger(String name) {
		super(name, null);
		this.setUseParentHandlers(false);
		Handler loghandler = new ConsoleHandler();
		loghandler.setFormatter(new LogFormatter());
		addHandler(loghandler);
	}
	
}
