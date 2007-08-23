package de.uka.ipd.sdq.scheduler.processes;

public class SleepAverageSensor implements IProcessStateSensor {


	/**
	 * @uml.property name="sleepAverage"
	 */
	private double sleepAverage;

	/**
	 * Getter of the property <tt>sleepAverage</tt>
	 * 
	 * @return Returns the sleepAverage.
	 * @uml.property name="sleepAverage"
	 */
	public double getSleepAverage() {
		return sleepAverage;
	}

	/**
	 * Setter of the property <tt>sleepAverage</tt>
	 * 
	 * @param sleepAverage
	 *            The sleepAverage to set.
	 * @uml.property name="sleepAverage"
	 */
	public void setSleepAverage(double sleepAverage) {
		this.sleepAverage = sleepAverage;
	}

	@Override
	public void update(PROCESS_STATE newState) {
	}

}
