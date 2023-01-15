package afia.nabil.time.service;

public interface TimeService extends TimeServiceProvider{
	
	public int getHour();
	public int getMinute();
	public int getSeconde();
	
	public void updateSeconde() ;
	public void updateMinute();
	public void updateHour() ;
}
