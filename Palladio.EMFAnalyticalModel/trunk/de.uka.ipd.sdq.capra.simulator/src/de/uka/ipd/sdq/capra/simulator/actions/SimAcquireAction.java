package de.uka.ipd.sdq.capra.simulator.actions;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.IPassiveResource;

/**
 * @author     jens.happe
 */
public class SimAcquireAction implements SimAction {

	private IPassiveResource resource;
	private int numberRequested;
	
	public SimAcquireAction(IPassiveResource resource, int numberRequested) {
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
		if (resource.acquire(capraProcess,numberRequested)){
			capraProcess.activate();
		}
	}
	
	public SimAcquireAction clone(){
		return new SimAcquireAction(resource,numberRequested);
	}
}
