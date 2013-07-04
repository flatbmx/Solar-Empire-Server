package com.podts.solarserver.economy;

public class Credits {
	
	private long amount, max = -1;
	
	public long getCredits() {
		return amount;
	}
	
	public long getMaximumCredits() {
		return max;
	}
	
	public boolean hasCredits(long c) {
		return amount >= c;
	}
	
	public void giveCredits(long c) {
		amount += c;
		if (amount > max && max > 0)
			amount = max;
	}
	
	public void takeCredits(long c) {
		amount -= c;
	}
	
	public boolean isFull() {
		return amount == max;
	}
	
	public Credits() {
		
	}
	
	public Credits(long amount) {
		this.amount = amount;
	}
	
	public Credits(long amount, long max) {
		this.amount = amount;
		this.max = max;
	}
	
}
