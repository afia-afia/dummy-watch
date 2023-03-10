package afia.nabil.TimeServiceWithDelegation;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import afia.nabil.core.lookup.Lookup;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;
import afia.nabil.time.service.TimeServiceProvider;
import afia.nabil.timer.service.impl.TimeServiceImpl;

public class TimeServiceImplWithDeleg extends TimerTask implements TimeService{
	private PropertyChangeSupport psc  =new PropertyChangeSupport(this) ;
	private int seconde;
	private int minute;
	private int hour;
	private Timer timer;
	public TimeServiceImplWithDeleg() {
		timer = new Timer();
		LocalTime localTime = LocalTime.now();
		seconde = localTime.getSecond();
		minute = localTime.getMinute();
		hour = localTime.getHour();
		Lookup.getInstance().register(TimeService.class, this);
		timer.scheduleAtFixedRate(this, 0, 1000);
	}
	
	@Override
	public void uRegisterListner(Listner l) {
		// TODO Auto-generated method stub
		psc.removePropertyChangeListener(l);;
	}
	
	@Override
	public void registerListner(Listner l) {
		// TODO Auto-generated method stub
		psc.addPropertyChangeListener(l);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		updateSeconde();
	//System.out.println("minute :" + minute + " seconde :" + seconde);
	}
	@Override
	public void updateSeconde() {
		// TODO Auto-generated method stub
		
		int oldVal = seconde;
		seconde = (oldVal+1)%60;
		psc.firePropertyChange(Listner.SECONDE_PROP, oldVal,1);
		if(seconde == 0 )
			updateMinute();
	}
	@Override
	public void updateMinute() {
		// TODO Auto-generated method stub
		int oldVal = minute;
		 minute = (minute+1)%60;
		
		psc.firePropertyChange(Listner.MINUTE_PROP, oldVal, 1);
		if(minute == 0)
			updateHour();
	}
	@Override
	public void updateHour() {
		int oldVal = hour;
		 hour = (hour+1)%24;
		psc.firePropertyChange(Listner.HEURE_PROP, oldVal,1);
	}

	@Override
	public int getHour() {
		// TODO Auto-generated method stub
		return hour;
	}

	@Override
	public int getMinute() {
		// TODO Auto-generated method stub
		return minute;
	}

	@Override
	public int getSeconde() {
		// TODO Auto-generated method stub
		return seconde;
	}
	
}