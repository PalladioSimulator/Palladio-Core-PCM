package de.uka.ipd.sdq.scheduler.events;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

/**
 * Event causing a call to the schedule method of the specified scheduling
 * strategy. Used to trigger a scheduling at a specific time.
 * 
 * @author jens
 * 
 */
public class SchedulingEvent extends Event {

	SimActiveResource containingResource;
	IResourceInstance instance;

	static Logger logger = Logger.getLogger(SchedulingEvent.class);
	
	static{
		logger.setLevel(Level.INFO);
	}
	
	public SchedulingEvent(SimActiveResource containingResource, IResourceInstance instance) {
		super(SchedulingFactory.getUsedSimulator());
		this.containingResource = containingResource;
		this.instance = instance;
	}

	@Override
	public void actions() {
		logger.debug(simulator().time() + " Scheduling Event handler triggered");
		containingResource.getScheduler().schedule(instance);
	}
}
