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
    public void eventRoutine(final ScheduledResource who) {
        who.setAvailable(false);
        if (this.getModel().getSimulationControl().isRunning()) {
            repairedEvent.schedule(who, who.getRepairTime());
        }
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
