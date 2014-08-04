package de.uka.ipd.sdq.simulation;

/**
 * Interface for observers interested in the progress of the simulation
 * 
 * @author Steffen Becker
 *
 */
public interface IStatusObserver {
    /**
     * Notification call informing the observer about the simulation progess in percent done
     * 
     * @param percentDone
     *            Percentage of the maximum simulation time which has passed
     */
    void updateStatus(int percentDone, double currentSimTime, long measurementsTaken);
}
