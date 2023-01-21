package afia.nabil.state;

public interface ClockState {
	public void plus(ReglableClock reglableClock);
	public void minus(ReglableClock reglableClock);
	public void changeState(ReglableClock c);
	public String toString() ;
}
