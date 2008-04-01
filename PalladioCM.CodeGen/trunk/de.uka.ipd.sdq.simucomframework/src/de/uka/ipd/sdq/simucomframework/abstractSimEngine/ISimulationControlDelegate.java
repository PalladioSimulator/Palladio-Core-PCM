package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import java.util.Observer;

public interface ISimulationControlDelegate {

	public abstract void start();

	public abstract void stop();

	public abstract double getCurrentSimulationTime();

	public abstract void setMaxSimTime(long simTime);

	public abstract void addStopCondition(Condition maxMeasurementsStopCondition);

	public abstract void addTimeObserver(Observer observer);

	public abstract boolean isRunning();

}