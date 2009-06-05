package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Represents a repair of an AbstractScheduledResource after a failure.
 * 
 * After the occurrence of the repair event, the resource is available again
 * until the next failure event occurs.
 * 
 * @author brosch
 * 
 */
public class ResourceRepairedEvent extends SimEvent {

	/**
	 * The resource that this event belongs to.
	 */
	private AbstractScheduledResource resource;

	/**
	 * The corresponding failure event.
	 */
	private ResourceFailedEvent failedEvent;

	/**
	 * The constructor.
	 * 
	 * @param model
	 *            the owner model
	 * @param name
	 *            the name of the event
	 */
	public ResourceRepairedEvent(final SimuComModel model, final String name) {
		super(model, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desmoj.core.simulator.Event#eventRoutine(desmoj.core.simulator.Entity)
	 */
	@Override
	public void eventRoutine(IEntityDelegate who) {
		resource.setAvailable(true);
		if (this.getModel().getSimulationControl().isRunning()) {
			failedEvent.schedule(resource, resource.getFailureTime());
		}
	}

	/**
	 * Retrieves the resource corresponding to the event.
	 * 
	 * @return the corresponding resource
	 */
	public AbstractScheduledResource getResource() {
		return resource;
	}

	/**
	 * Sets the resource corresponding to the event.
	 * 
	 * @param resource
	 *            the resource to set
	 */
	public void setResource(final AbstractScheduledResource resource) {
		this.resource = resource;
	}

	/**
	 * Retrieves the corresponding failure event.
	 * 
	 * @return the failure event
	 */
	public ResourceFailedEvent getFailedEvent() {
		return failedEvent;
	}

	/**
	 * Sets the corresponding failure event.
	 * 
	 * @param failedEvent
	 *            the failure event
	 */
	public void setFailedEvent(final ResourceFailedEvent failedEvent) {
		this.failedEvent = failedEvent;
	}
}
