package afia.nabil.launcher;

import java.awt.EventQueue;

import afia.nabil.TimeServiceWithDelegation.TimeServiceImplWithDeleg;
import afia.nabil.gui.Clock;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;
import afia.nabil.timer.service.impl.TimeServiceImpl;

public class Main {
	public static void main( String[] args )
    {
		TimeServiceImplWithDeleg timeService = new TimeServiceImplWithDeleg();
        Clock listner =  new Clock(timeService);//
        EventQueue.invokeLater(new Runnable() {
			public void run() {
		     	
			}
		});
    }
}
