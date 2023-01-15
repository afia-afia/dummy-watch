package afia.nabil.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	JLabel hour;
	JLabel minute;
	JLabel seconde;
	JLabel sep;
	JLabel sep1;
	
	 public ClockPanel() {
		// TODO Auto-generated constructor stub
		hour = new JLabel();
		minute = new JLabel();
		seconde = new JLabel();
		sep = new JLabel(":");
		sep1 = new JLabel(":");
		this.setLayout(new GridLayout(1, 5));
		this.add(hour);
		this.add(sep);
		this.add(minute);
		this.add(sep1);
		this.add(seconde);
	}
	   public void setHour(String hour) {
			this.hour.setText(hour);
		}

		public void setMinute(String minute) {
			this.minute.setText(minute); 
		}

		public void setSeconde(String seconde) {
			this.seconde.setText(seconde);
		}

}
