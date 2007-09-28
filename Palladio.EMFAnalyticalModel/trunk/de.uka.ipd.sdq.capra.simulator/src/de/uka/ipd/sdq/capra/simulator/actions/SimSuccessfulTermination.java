package de.uka.ipd.sdq.capra.simulator.actions;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;

public class SimSuccessfulTermination implements SimAction {

	public SimSuccessfulTermination clone(){
		return this;
	}

	@Override
	public void useSensorInstances(Hashtable<String,SimSensorInstance> sensorInstanceTable) {
		// nothing to do
	}

	@Override
	public void reset() {
	}

	@Override
	public SimCapraExpression getNext() {
		return null;
	}

	@Override
	public boolean isAction() {
		return true;
	}

	@Override
	public void execute(SimCapraProcess capraProcess) {
		// nothing to do
		capraProcess.activate();
	}

}
