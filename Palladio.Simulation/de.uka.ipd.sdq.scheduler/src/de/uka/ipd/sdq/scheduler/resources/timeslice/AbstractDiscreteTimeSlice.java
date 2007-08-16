package de.uka.ipd.sdq.scheduler.resources.timeslice;


public abstract class AbstractDiscreteTimeSlice implements ITimeSlice {
	
	@Override
	public void getTimeUntilNextInterruption() {
	}

	@Override
	public boolean isFinished() {
		return remainingTicks == 0;
	}

	@Override
	public void passTime(double time) {
	}

	@Override
	public abstract void reset();

	/**
	 * @uml.property  name="remainingTicks"
	 */
	private int remainingTicks;

	/**
	 * Getter of the property <tt>remainingTicks</tt>
	 * @return  Returns the remainingTicks.
	 * @uml.property  name="remainingTicks"
	 */
	public int getRemainingTicks() {
		return remainingTicks;
	}

	/**
	 * Setter of the property <tt>remainingTicks</tt>
	 * @param remainingTicks  The remainingTicks to set.
	 * @uml.property  name="remainingTicks"
	 */
	public void setRemainingTicks(int remainingTicks) {
		this.remainingTicks = remainingTicks;
	}
}
