package com.podts.solarserver;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class RecycledIntList {
	
	private List<Integer> free = new LinkedList<Integer>();
	private int next;
	
	public Collection<Integer> getFreeInts() {
		return free;
	}
	
	public synchronized int getID() {
		if (!free.isEmpty()) {
			int r = free.get(0);
			free.remove(0);
			return r;
		}
		next++;
		return next;
	}
	
	public synchronized void recycle(int i) {
		for (int m=0;m<free.size();m++) {
			if (free.get(m) > i) {
				free.add(m, i);
				return;
			}
		}
		free.add(i);
	}
	
}
