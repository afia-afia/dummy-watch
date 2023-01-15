package afia.nabil.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import afia.nabil.TimeServiceWithDelegation.TimeServiceImplWithDeleg;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;
import afia.nabil.timer.service.impl.TimeServiceImpl;
public class Clock implements Listner {
	private int  hour;
	private int minute;
	private int seconde;
	TimeService timeService;
	JFrame frame ;
	ClockPanel panel ;
	JButton button = new JButton("mode");
	JButton plusButton = new JButton("plus");
	JButton minusButton = new JButton("minus");
	public Clock(TimeServiceImplWithDeleg e) {
		// TODO Auto-generated constructor stub
		timeService = e;
		timeService.registerListner(this);
		hour = timeService.getHour();
		minute = timeService.getMinute();
		seconde = timeService.getSeconde();
		init();
	}
	/*@Override
	public void propertyChange(String propertyName, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		if (propertyName.equals(Listner.SECONDE_PROP)) {
			panel.setSeconde(String.valueOf(newValue));
			
		}
		
		if (propertyName.equals(Listner.MINUTE_PROP)) {
			
			panel.setMinute(String.valueOf(newValue));
		}
		
	}*/
	public void init() {
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Digital Clock");
	    frame.setSize(300,150);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new GridLayout(2, 3));
	    frame.getContentPane().setBackground(Color.white);
	     panel = new ClockPanel();
	     frame.add(panel);
	     frame.add(button);
	     frame.add(plusButton);
	     frame.add(minusButton);
	    panel.setSeconde(String.valueOf(minute));
	    panel.setMinute(String.valueOf(minute));
	    panel.setHour(String.valueOf(hour));
	     frame.setVisible(true);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName().equals(Listner.SECONDE_PROP))
				panel.setSeconde(String.valueOf(evt.getNewValue()));
		
		if (evt.getPropertyName().equals(Listner.MINUTE_PROP)) {
			panel.setMinute(String.valueOf(evt.getNewValue()));
		}
	}
	@Override
	public void propertyChange(String propertyName, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		
	}
}
