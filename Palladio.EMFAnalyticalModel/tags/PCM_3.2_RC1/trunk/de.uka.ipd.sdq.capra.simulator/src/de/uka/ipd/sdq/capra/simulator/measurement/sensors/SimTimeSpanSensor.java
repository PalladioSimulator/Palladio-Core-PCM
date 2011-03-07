package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface SimTimeSpanSensor extends SimSensor {

	public abstract void addTimeSpan(double timeSpan, double time);

	public abstract void notifyStart(double time, ISchedulableProcess p);

	public abstract void notifyStop(double time, ISchedulableProcess p);

}