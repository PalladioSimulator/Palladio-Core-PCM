package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.processes.SleepAverageSensor;


public class SleepAverageDependentUpdate extends AbstractPriorityUpdate {

	@Override
	public boolean update(ProcessWithPriority process) {
		return false;
	}

	/**
	 * @uml.property   name="sleepAverageSensor"
	 * @uml.associationEnd   aggregation="composite" inverse="dynamicUpdateStrategy:de.uka.ipd.sdq.scheduler.processes.SleepAverageSensor"
	 */
	private SleepAverageSensor sleepAverageSensor;

	/**
	 * Getter of the property <tt>sleepAverageSensor</tt>
	 * @return  Returns the sleepAverageSensor.
	 * @uml.property  name="sleepAverageSensor"
	 */
	public SleepAverageSensor getSleepAverageSensor() {
		return sleepAverageSensor;
	}

	/**
	 * Setter of the property <tt>sleepAverageSensor</tt>
	 * @param sleepAverageSensor  The sleepAverageSensor to set.
	 * @uml.property  name="sleepAverageSensor"
	 */
	public void setSleepAverageSensor(SleepAverageSensor sleepAverageSensor) {
		this.sleepAverageSensor = sleepAverageSensor;
	}

}
