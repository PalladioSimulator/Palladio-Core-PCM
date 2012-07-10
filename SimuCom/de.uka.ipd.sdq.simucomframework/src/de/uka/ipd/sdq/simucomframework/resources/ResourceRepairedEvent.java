package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

/**
 * Represents a repair of an AbstractScheduledResource after a failure.
 * 
 * After the occurrence of the repair event, the resource is available again until the next failure
 * event occurs.
 * 
 * @author brosch
 * 
 */
public class ResourceRepairedEvent extends AbstractSimEventDelegator<AbstractScheduledResource> {

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
     * @seede.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent#eventRoutine(de.uka.ipd.sdq.
     * simucomframework.abstractSimEngine.IEntityDelegate)
     */
    public void eventRoutine(AbstractScheduledResource who) {
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
