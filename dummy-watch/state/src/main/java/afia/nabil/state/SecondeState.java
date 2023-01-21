package afia.nabil.state;

public class SecondeState implements ClockState {
	
	@Override
	public void changeState(ReglableClock c) {
		// TODO Auto-generated method stub
		c.setState(new MinuteState());
	}

	@Override
	public void plus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		reglableClock.setSeconde(reglableClock.getSeconde()+1);
	}

	@Override
	public void minus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		reglableClock.setSeconde(reglableClock.getSeconde()-1);
	}
	
}
