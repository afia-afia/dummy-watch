package afia.nabil.launcher;

import java.awt.EventQueue;

import afia.nabil.TimeServiceWithDelegation.TimeServiceImplWithDeleg;
import afia.nabil.core.lookup.Lookup;
import afia.nabil.gui.Clock;
import afia.nabil.gui.ReglableGui;
import afia.nabil.state.ReglableClock;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;
import afia.nabil.timer.service.impl.TimeServiceImpl;

public class Main {
 
	public static void main( String[] args )
    {
		TimeService timeService = new TimeServiceImplWithDeleg();
		ReglableGui gui = new ReglableGui();
       /* EventQueue.invokeLater(new Runnable() {
			public void run() {
		     	
			}
		});*/
        
    }
}
