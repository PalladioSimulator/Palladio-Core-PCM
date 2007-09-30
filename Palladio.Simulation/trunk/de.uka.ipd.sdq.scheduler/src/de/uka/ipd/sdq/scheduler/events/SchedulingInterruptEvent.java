package de.uka.ipd.sdq.scheduler.events;

import umontreal.iro.lecuyer.simevents.Event;
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
	private boolean quantum_finished;

	public SchedulingInterruptEvent(SimActiveResource containingResource, IResourceInstance instance, boolean quantum_finished) {
		super();
		this.containingResource = containingResource;
		this.instance = instance;
		this.quantum_finished = quantum_finished;
	}

	@Override
	public void actions() {
		containingResource.getScheduler().schedule(instance,quantum_finished);
	}
}
