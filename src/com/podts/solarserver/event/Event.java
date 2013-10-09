package com.podts.solarserver.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.podts.solarserver.interfaces.HasName;

public abstract class Event implements HasName {
	
	private static List<EventHandler> handlers = new ArrayList<EventHandler>();
	
	public static void addHandler(EventHandler e) {
		handlers.add(e);
	}
	
	public static void removeHandler(EventHandler e) {
		handlers.remove(e);
	}
	
	final private String name;
	private boolean cancel = false;
	
	@Override
	public String getName() {
		return name;
	}
	
	public boolean isCancelled() {
		return cancel;
	}
	
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
	
	public abstract void execute();
	
	public void fire() {
		
		if (cancel)
			return;
		
		for (EventHandler h : handlers) {
			for (Method m : h.getClass().getMethods()) {
				if (cancel)
					return;
				if (m.isAnnotationPresent(Listener.class)) {
					for (Class<?> c : m.getParameterTypes()) {
						if (c.isAssignableFrom(this.getClass())) {
							try {
								m.invoke(h, this);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		
		if (cancel)
			return;
		
		execute();
		
	}
	
	public Event(String name) {
		this.name = name;
	}
	
}
