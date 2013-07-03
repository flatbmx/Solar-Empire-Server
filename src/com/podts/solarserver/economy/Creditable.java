package com.podts.solarserver.economy;

public interface Creditable {
	
	public long getCredits();
	public long getMaximumCredits();
	public void setCredits(long credits);
	
	public boolean hasCredits(long credits);
	
	public void takeCredits(long credits);
	public void giveCredits(long credits);
	
}
