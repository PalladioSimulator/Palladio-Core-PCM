package de.uka.ipd.sdq.scheduler.events;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

/**
 * Event causing a call to the schedule method of the specified scheduling
 * strategy. Used to trigger a scheduling at a specific time.
 * 
 * @author jens
 * 
 */
public class SchedulingEvent extends AbstractSimEventDelegator<IResourceInstance> {

	SimActiveResource containingResource;
	
	static Logger logger = Logger.getLogger(SchedulingEvent.class);
	
	static{
		logger.setLevel(Level.INFO);
	}
	
	public SchedulingEvent(SchedulerModel model, SimActiveResource containingResource) {
		super(model, SchedulingEvent.class.getName());
		this.containingResource = containingResource;
	}

	@Override
	public void eventRoutine(IResourceInstance instance) {
		logger.debug(getModel().getSimulationControl().getCurrentSimulationTime() + " Scheduling Event handler triggered");
		containingResource.getScheduler().schedule(instance);
	}

}
