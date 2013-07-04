package com.podts.solarserver.console;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import com.podts.solarserver.Server;

import jline.ConsoleOperations;

public class LogFormatter extends Formatter {

	public static void init() {
		Server.getServer().getLogger().setUseParentHandlers(false);
		Handler loghandler = new ConsoleHandler();
		loghandler.setFormatter(new LogFormatter());
		Server.getServer().getLogger().addHandler(loghandler);
	}
	
	@Override
	public String format(LogRecord record) {
		String message = "";
		Date date = new Date(record.getMillis());
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		if (Console.getReader() != null) {
			message += ConsoleOperations.RESET_LINE;
		}
		message += "[" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + "] " + record.getLoggerName() + " ";
		String levelcolor = "", messagecolor = "";
		switch (record.getLevel().intValue()) {
			case 800:
				// Info
				levelcolor = ANSIColor.GREEN.toString();
				break;
			case 1000:
				// SEVERE
				levelcolor = "" + ANSIColor.RED + ANSIColor.BACKGROUND_YELLOW;
				messagecolor = ANSIColor.RED.toString();
				break;
		}
		
		message += levelcolor + record.getLevel() + ANSIColor.RESET + ": " + messagecolor + record.getMessage() + ANSIColor.RESET ;
		
		if (Console.getTerminal() != null) {
			int messagelength = ("[" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + "] " + record.getLoggerName() + " " + record.getLevel()
			+ ": " + record.getMessage() ).length();
			
			if ( messagelength < Console.getTerminal().getTerminalWidth() - 1 ) {
			
			String extraspaces = "";
			
			int def = Console.getTerminal().getTerminalWidth() - 1 - messagelength;
			
			for (int i=0; i<def; i++) {
				extraspaces += " ";
			}
			message += extraspaces;
			
			}
		}
		
		message += "\n";
		
		return message;
		
	}

}
