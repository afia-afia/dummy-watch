package afia.nabil.ConfigState;



import afia.nabil.gui.Clock;

public class SecondeState implements StateConf {
	@Override
	public void minus(Clock c) {
		// TODO Auto-generated method stub
		c.setSeconde(c.getSeconde()-1);
	}
	@Override
		public void plus(Clock c) {
			// TODO Auto-generated method stub
		c.setSeconde(c.getSeconde()-1);	
	}
	@Override
	public void mode(Clock c) {
		// TODO Auto-generated method stub
		
	}
	
}
