package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.resources.SimPassiveResource;

public class SimReleaseAction implements SimAction {

	private SimPassiveResource resource;
	private int numberReleased;
	
	public SimReleaseAction(SimPassiveResource resource, int numberReleased) {
		super();
		this.resource = resource;
		this.numberReleased = numberReleased;
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
		resource.release(capraProcess, numberReleased);
	}
	
	public SimReleaseAction clone(){
		return new SimReleaseAction(resource,numberReleased);
	}

}
