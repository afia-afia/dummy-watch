package afia.nabil.state;

public class HourState implements ClockState {

	

	@Override
	public void changeState(ReglableClock c) {
		// TODO Auto-generated method stub
		c.getTimeService().registerListner(c);
		c.setState(new StartState());
		
	}

	@Override
	public void plus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		reglableClock.setHour(reglableClock.getHour()+1);
	}

	@Override
	public void minus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		reglableClock.setHour(reglableClock.getHour()-1);
	}

}
