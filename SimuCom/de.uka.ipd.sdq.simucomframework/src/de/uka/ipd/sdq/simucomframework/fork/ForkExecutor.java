package de.uka.ipd.sdq.simucomframework.fork;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;

/**
 * Helper to execute a fork action in the PCM. Implements the barrier design pattern.
 * 
 * @author Steffen Becker
 *
 */
public class ForkExecutor {
    private final ForkedBehaviourProcess[] forks;
    private final SimuComSimProcess parent;
    private static final Logger LOGGER = Logger.getLogger(ForkExecutor.class.getName());

    /**
     * Initialise the barrier with the forks to spawn and the parent process which is continoued
     * when all forks are done
     * 
     * @param parent
     *            The parent simulation thread
     * @param forks
     *            The threads to run in parallel
     */
    public ForkExecutor(SimuComSimProcess parent, ForkedBehaviourProcess[] forks) {
        this.forks = forks;
        this.parent = parent;
    }

    /**
     * Execute the child threads in parallel waiting for them to finish
     */
    public void run() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Running parallel operations");
        }
        double start = parent.getModel().getSimulationControl().getCurrentSimulationTime();
        for (ForkedBehaviourProcess p : forks) {
            p.scheduleAt(0);
        }
        while (checkIfRemainingChildrenRun()) {
            parent.passivate();
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Forks took: " + (parent.getModel().getSimulationControl().getCurrentSimulationTime() - start));
        }
    }

    /**
     * @return True if there are child forks still running. This needs not be threadsafe as desmoj
     *         always exeutes only a single thread
     */
    private boolean checkIfRemainingChildrenRun() {
        for (ForkedBehaviourProcess p : forks) {
            if (!p.isAsync() && !p.isTerminated()) {
                return true;
            }
        }
        return false;
    }
}
