package de.uka.ipd.sdq.capra.simulator.actions;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.IPassiveResource;

/**
 * @author     jens.happe
 */
public class SimReleaseAction implements SimAction {

	private IPassiveResource resource;
	private int numberReleased;
	
	public SimReleaseAction(IPassiveResource resource, int numberReleased) {
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
		capraProcess.activate();
	}
	
	public SimReleaseAction clone(){
		return new SimReleaseAction(resource,numberReleased);
	}

}
