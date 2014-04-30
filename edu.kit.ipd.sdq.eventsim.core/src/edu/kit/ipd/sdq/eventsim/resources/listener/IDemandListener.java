package edu.kit.ipd.sdq.eventsim.resources.listener;

/**
 * A demand listener observes a {@link SimActiveResource} for resource demands. Whenever a demand is
 * issued, the resource notifies its observers by calling the {@code demand} method on the
 * listeners.
 * 
 * @author Philipp Merkle
 * 
 * @see SimActiveResource#addDemandListener(IDemandListener)
 */
public interface IDemandListener {

    /**
     * Called when a resource demand has been issued.
     * 
     * @param demand
     *            the resource demand that has been requested
     */
    public void demand(double demand);

}
