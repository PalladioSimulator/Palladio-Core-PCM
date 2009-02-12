package de.uka.ipd.sdq.scheduler.events;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

/**
 * Event causing a call to the schedule method of the specified scheduling
 * strategy. Used to trigger a scheduling at a specific time.
 * 
 * This Event will never be canceled and can exist an arbitrary number of times in the event queue.
 * 
 * @author jens
 * 
 */
public class SchedulingInterruptEvent extends Event {

	SimActiveResource containingResource;
	IResourceInstance instance;
	static Logger logger = Logger.getLogger(SchedulingInterruptEvent.class);

	public SchedulingInterruptEvent(SimActiveResource containingResource, IResourceInstance instance) {
		super(SchedulingFactory.getUsedSimulator());
		this.containingResource = containingResource;
		this.instance = instance;
	}

	@Override
	public void actions() {
		LoggingWrapper.log("Scheduling Interrupt Event handler triggered");
		containingResource.getScheduler().schedule(instance/*,quantum_finished*/);
	}
}
