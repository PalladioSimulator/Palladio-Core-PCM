package edu.kit.ipd.sdq.eventsim.resources.listener;

/**
 * An overall utilisation listener observes a {@link SimActiveResource} for their utilisation. When
 * the simulation is about to finish and the overall resource utilisation is known, the resource
 * notifies its observers once by calling the {@code utilizationChanged} method on the
 * listeners.
 * 
 * @author Philipp Merkle
 * 
 * @see SimActiveResource#addOverallUtilizationListener(IOverallUtilizationListener)
 */
public interface IOverallUtilizationListener {

    /**
     * Called as soon as the overall utilisation of the resource is known.
     */
    void utilizationChanged(double resourceDemand, double totalTime);

}
