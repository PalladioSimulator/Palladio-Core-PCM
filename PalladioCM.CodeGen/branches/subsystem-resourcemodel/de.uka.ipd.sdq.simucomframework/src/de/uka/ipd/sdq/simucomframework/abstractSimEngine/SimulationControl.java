package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import java.util.Observer;

public class SimulationControl implements ISimulationControlDelegate {
	ISimulationControlDelegate delegate = null;

	public void addStopCondition(Condition maxMeasurementsStopCondition) {
		delegate.addStopCondition(maxMeasurementsStopCondition);
	}

	public void addTimeObserver(Observer observer) {
		delegate.addTimeObserver(observer);
	}

	public double getCurrentSimulationTime() {
		return delegate.getCurrentSimulationTime();
	}

	public void setMaxSimTime(long simTime) {
		delegate.setMaxSimTime(simTime);
	}

	public void start() {
		delegate.start();
	}

	public void stop() {
		delegate.stop();
	}

	public boolean isRunning() {
		return delegate.isRunning();
	}
	
}
