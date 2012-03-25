package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.events;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;

/**
 * Event causing a call to the schedule method of the specified scheduling
 * strategy. Used to trigger a scheduling at a specific time.
 * 
 * This Event will never be canceled and can exist an arbitrary number of times in the event queue.
 * 
 * @author jens
 * 
 */
public class SchedulingInterruptEvent extends AbstractSimEventDelegator<IResourceInstance> {

	SimActiveResource containingResource;
	static Logger logger = Logger.getLogger(SchedulingInterruptEvent.class);

	public SchedulingInterruptEvent(SchedulerModel model, SimActiveResource containingResource) {
		super(model, SchedulingEvent.class.getName());
		this.containingResource = containingResource;
	}

	@Override
	public void eventRoutine(IResourceInstance instance) {
		LoggingWrapper.log("Scheduling Interrupt Event handler triggered");
		containingResource.getScheduler().schedule(instance/*,quantum_finished*/);
	}

}
