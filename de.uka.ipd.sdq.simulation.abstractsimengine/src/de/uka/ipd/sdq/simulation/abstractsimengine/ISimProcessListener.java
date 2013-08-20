package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * This listener can be registered with a {@link ISimProcess} in order to receive a notification
 * whenever the process is suspended or resumed again.
 * 
 * @author Philipp Merkle
 * 
 */
public interface ISimProcessListener {

    /**
     * This method is called whenever the given simulated process is about to be resumed.
     * 
     * @param process
     *            the simulated process
     */
    public void notifyResuming(ISimProcess process);

    /**
     * This method is called whenever the given simulated process is about to be suspended.
     * 
     * @param process
     *            the simulated process
     */
    public void notifySuspending(ISimProcess process);

}
