package de.uka.ipd.sdq.capra.simulator.resources_new;


public abstract class AbstractDiscreteTimeSlice implements ITimeSlice {
	
	protected int remainingTime;

	@Override
	public void getTimeUntilNextInterruption() {
	}

	@Override
	public boolean isFinished() {
		return remainingTime == 0;
	}

	@Override
	public void passTime(double time) {
	}

	@Override
	public abstract void reset();
}
