package com.podts.solarserver.filesystem;

import java.io.File;

public class FileManager {
	
	private static FileManager manager;
	
	public static FileManager getManager() {
		if (manager == null)
			manager = new FileManager();
		return manager;
	}
	
	private File dir;
	private File universedir;
	
	public File getDir() {
		return dir;
	}
	
	public File getUniDir() {
		return universedir;
	}
	
	public FileManager() {
		dir = new File(System.getProperty("user.dir"));
		universedir = new File(dir.getPath() + File.separator + "Uni");
		universedir.mkdir();
	}
	
}