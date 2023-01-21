package afia.nabil.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Taskbar.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import afia.nabil.Context.ReglableClockInterface;
import afia.nabil.core.lookup.Lookup;
import afia.nabil.state.ReglableClock;
import afia.nabil.time.service.Listner;
import afia.nabil.time.service.TimeService;

public class ReglableGui implements Listner {
	JFrame frame ;
	ClockPanel panel ;
	JButton button = new JButton("mode");
	JButton plusButton = new JButton("plus");
	JButton minusButton = new JButton("minus");
	ReglableClockInterface reglableClock;
	TimeService timeService ;
	JLabel stateLabel = new JLabel();
	public ReglableGui() {
		// TODO Auto-generated constructor stub$
		reglableClock = new ReglableClock();
		timeService = Lookup.getInstance().getService(TimeService.class);
		timeService.registerListner(this);
		init();
	}
	
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
	     button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modeAction();
			}
		}
	     );
	     plusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				plusAcion();
				
			}
		});
	     minusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				minusAcion();
			}
		});
	     panel.setSeconde(String.valueOf(reglableClock.getSeconde()));
		 panel.setMinute(String.valueOf(reglableClock.getMinute()));
		 panel.setHour(String.valueOf(reglableClock.getHour()));
	     frame.setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName().equals(Listner.SECONDE_PROP)) {
			
			 panel.setSeconde(String.valueOf(reglableClock.getSeconde()));
			 panel.setMinute(String.valueOf(reglableClock.getMinute()));
			
		}
		if (evt.getPropertyName().equals(Listner.MINUTE_PROP)) {
			
		}
		
	}

	@Override
	public void propertyChange(String propertyName, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		
	}
	private void modeAction() {
		this.reglableClock.mode();
	}
	private void plusAcion() {
		this.reglableClock.plus();
	}
	private void minusAcion() {
		this.reglableClock.minus();
	}
}
