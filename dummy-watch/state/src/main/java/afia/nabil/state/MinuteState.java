package afia.nabil.state;

public class MinuteState implements ClockState {
	@Override
	public void changeState(ReglableClock c) {
		// TODO Auto-generated method stub
		c.setState(new HourState());
	}

	@Override
	public void plus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		System.out.println("minute State plus");
		reglableClock.setMinute(reglableClock.getMinute()+1);
	}

	@Override
	public void minus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		reglableClock.setMinute(reglableClock.getMinute()-1);
	}
}
