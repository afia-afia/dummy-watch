package afia.nabil.timer.service.impl;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import afia.nabil.core.lookup.Lookup;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;

public class TimeServiceImpl extends TimerTask implements TimeService {
	protected int seconde;
	private int minute;
	private int hour;
	private List<Listner> listners = new ArrayList<>();
	Timer timer ;
	public TimeServiceImpl() {
		// TODO Auto-generated constructor stub
		timer = new Timer();
		LocalTime localTime = LocalTime.now();
		seconde = localTime.getSecond();
		minute = localTime.getMinute();
		hour = localTime.getHour();
		timer.scheduleAtFixedRate(this, 0, 1000);
		Lookup.getInstance().register(TimeService.class,this);
	}

	@Override
	public void registerListner(Listner l) {
		// TODO Auto-generated method stub
		listners.add(l);
	}

	@Override
	public void uRegisterListner(Listner l) {
		// TODO Auto-generated method stub
		listners.remove(l);
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

	@Override
	public void updateSeconde() {
		// TODO Auto-generated method stub
		int old = seconde ;
		int newvalu = ( old + 1 ) % 60;
		seconde = newvalu;
		
	    for (Listner listner : listners) {
			listner.propertyChange(Listner.SECONDE_PROP, Integer.valueOf(old), Integer.valueOf(newvalu));
		}
		if (newvalu == 0) {
			updateMinute();
		}
		
	}

	@Override
	public void updateMinute() {
		// TODO Auto-generated method stub
		int old = minute ;
		int newvalu = (minute+1)%60;
		minute = newvalu;
	    for (Listner listner : listners) {
			listner.propertyChange(Listner.MINUTE_PROP, Integer.valueOf(old), Integer.valueOf(newvalu));
		}
		if (newvalu == 0) {
			updateHour();
		}
	}

	@Override
	public void updateHour() {
		// TODO Auto-generated method stub
		int old = hour ;
		int newvalu = (hour+1)%24;
	    for (Listner listner : listners) {
			listner.propertyChange(Listner.HEURE_PROP, Integer.valueOf(old), Integer.valueOf(newvalu));
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		updateSeconde();
		System.out.println("minute :" + minute + " seconde :" + seconde);
	}
	 
}
