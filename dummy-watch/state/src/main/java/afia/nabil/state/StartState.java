package afia.nabil.state;

public class StartState implements ClockState {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Start State";
	}


	@Override
	public void changeState(ReglableClock c) {
		// TODO Auto-generated method stub
		c.getTimeService().uRegisterListner(c);
		c.setState(new SecondeState());

	}

	@Override
	public void plus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minus(ReglableClock reglableClock) {
		// TODO Auto-generated method stub
		
	}

}
