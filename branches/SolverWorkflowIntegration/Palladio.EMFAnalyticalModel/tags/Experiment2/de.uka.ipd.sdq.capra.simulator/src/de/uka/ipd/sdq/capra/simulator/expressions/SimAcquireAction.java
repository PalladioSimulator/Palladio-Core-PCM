package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.resources.SimPassiveResource;

public class SimAcquireAction implements SimAction {

	private SimPassiveResource resource;
	private int numberRequested;
	
	public SimAcquireAction(SimPassiveResource resource, int numberRequested) {
		super();
		this.resource = resource;
		this.numberRequested = numberRequested;
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
	public void reset() {
	}

	@Override
	public void useSensorInstances(
			Hashtable<String, SimSensorInstance> sensorInstanceTable) {
	}

	@Override
	public void execute(SimCapraProcess capraProcess) {
		resource.acquire(capraProcess,numberRequested);
	}
	
	public SimAcquireAction clone(){
		return new SimAcquireAction(resource,numberRequested);
	}
}
