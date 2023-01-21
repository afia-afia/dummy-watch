package afia.nabil.Context;

import afia.nabil.time.service.Listner;

public interface ReglableClockInterface extends Listner {
	public int getSeconde();
	public void setSeconde(int x);
	public int getMinute();
	public void setMinute(int x);
	public int getHour();
	public void setHour(int x);
	
	public void mode();
	public void minus();
	public void plus();
}
