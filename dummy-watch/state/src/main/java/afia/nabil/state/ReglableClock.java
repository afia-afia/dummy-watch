package afia.nabil.state;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import afia.nabil.Context.ReglableClockInterface;
import afia.nabil.core.lookup.Lookup;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;

public class ReglableClock implements ReglableClockInterface{
	ClockState state;
	TimeService timeService;
	private int seconde;
	private int minute;
	private int hour;
	
	public void minus() {
		state.minus(this);
	}
	public TimeService getTimeService() {
		return timeService;
	}
	public int getSeconde() {
		return seconde;
	}
	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void plus() {
		state.plus(this);
	}
	public void mode() {
		System.out.println(state.toString());
		state.changeState(this);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName().equals(Listner.SECONDE_PROP)) {
			seconde =( seconde + 1) %60;
			
		}
		if (evt.getPropertyName().equals(Listner.MINUTE_PROP)) {
			minute = minute + 1;
		}
		
	}
	@Override
		public void propertyChange(String propertyName, Object oldValue, Object newValue) {
			// TODO Auto-generated method stub
			
		}
	public ReglableClock() {
		// TODO Auto-generated constructor stub
		timeService = Lookup.getInstance().getService(TimeService.class);
		timeService.registerListner(this);
		seconde  = timeService.getSeconde();
		minute = timeService.getMinute();
		hour = timeService.getHour();
		state = new StartState();
		Lookup.getInstance().register(Listner.class, this);
	}
	public void setState(ClockState s) {
		this.state = s; 
	}
	public ClockState getState() {
		return state;
	}

}
