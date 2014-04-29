package edu.kit.ipd.sdq.eventsim.resources.listener;

/**
 * A state listener observes a {@link SimActiveResource} for state changes. The resource state is
 * the length of the resource's queue. Whenever the state changes, the resource notifies its
 * observers by calling the {@code stateChanges} method on the listeners.
 * 
 * @author Philipp Merkle
 * 
 * @see SimActiveResource#addStateListener(IStateListener, int)
 */
public interface IStateListener {

    /**
     * Called whenever the resource state changes.
     * 
     * @param state
     *            the length of the resource's queue
     * @param instanceId
     *            an identifier for the resource instance, for instance a CPU core. If the resource
     *            has only one instance, the instanceId must be 0 for that instance.
     */
    public void stateChanged(int state, int instanceId);

}
