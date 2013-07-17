package com.podts.solarserver.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerManager {
	
	private static PlayerManager instance;
	
	public static PlayerManager getPlayerManager() {
		return instance;
	}
	
	private List<Player> players = new ArrayList<Player>();
	private int max;
	
	public Collection<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(int id) {
		if (players.size() < id)
			return null;
		return players.get(id);
	}
	
	public Player getPlayer(String name) {
		if (name == null)
			return null;
		for (Player p : players) {
			if (p.getName().equals(name))
				return p;
		}
		return null;
	}
	
	public int addPlayer(Player p) {
		players.add(p);
		return players.indexOf(p);
	}
	
	public void removePlayer(Player p) {
		if (players.size() < p.getID())
			return;
		players.remove(p.getID());
	}
	
	public int getMaximumPlayers() {
		return max;
	}
	
	public int getFreeSlots() {
		return max-players.size();
	}
	
	public PlayerManager(int max) {
		this.max = max;
		if (instance == null)
			instance = this;
	}
	
}
