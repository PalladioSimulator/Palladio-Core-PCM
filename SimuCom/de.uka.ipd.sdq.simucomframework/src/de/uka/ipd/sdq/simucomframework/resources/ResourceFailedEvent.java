package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

/**
 * Represents a failure of an AbstractScheduledResource.
 * 
 * After the occurrence of the failure event, the resource remains unavailable
 * until the next repair event occurs.
 * 
 * @author brosch, Sebastian Lehrig
 * 
 */
public class ResourceFailedEvent extends AbstractSimEventDelegator<ScheduledResource> {

	/**
	 * The resource that this event belongs to.
	 */
	private ScheduledResource resource;

	/**
	 * The corresponding repair event.
	 */
	private ResourceRepairedEvent repairedEvent;

	/**
	 * The constructor.
	 * 
	 * @param model
	 *            the owner model
	 * @param name
	 *            the name of the event
	 */
	public ResourceFailedEvent(final SimuComModel model, final String name) {
		super(model, name);
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent#eventRoutine(de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate)
	 */
	@Override
    public void eventRoutine(ScheduledResource who) {
		resource.setAvailable(false);
		if (this.getModel().getSimulationControl().isRunning()) {
			repairedEvent.schedule(resource, resource.getRepairTime());
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
	public void setResource(final ScheduledResource resource) {
		this.resource = resource;
	}

	/**
	 * Retrieves the corresponding repair event.
	 * 
	 * @return the repair event
	 */
	public ResourceRepairedEvent getRepairedEvent() {
		return repairedEvent;
	}

	/**
	 * Sets the corresponding repair event.
	 * 
	 * @param repairedEvent
	 *            the repair event
	 */
	public void setRepairedEvent(final ResourceRepairedEvent repairedEvent) {
		this.repairedEvent = repairedEvent;
	}
}
