package de.uka.ipd.sdq.simucomframework.fork;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess;

/**
 * Base class for ForkBehaviours. Generator creates a specialisation of this and uses it to execute
 * actions in parallel
 *
 * @author Steffen Becker
 *
 */
public abstract class ForkedBehaviourProcess extends SimuComSimProcess {

    protected final Context myContext;
    private final ISimProcess parentProcess;
    protected final String assemblyContextID;
    private final boolean isAsync;
    private boolean isTerminated = false;

    private static final Logger LOGGER = Logger.getLogger(ForkedBehaviourProcess.class.getName());

    public ForkedBehaviourProcess(final Context myContext, final String assemblyContextID, final boolean isAsync) {
        super(myContext.getModel(), "Forked Behaviour", myContext.getThread().getRequestContext());

        // use the session id from the parent process
        this.currentSessionId = myContext.getThread().getCurrentSessionId();

        this.myContext = createForkContext(myContext);

        this.parentProcess = myContext.getThread();
        this.assemblyContextID = assemblyContextID;
        this.isAsync = isAsync;
    }

    /**
     * Factory method for the fork context used in the forked behaviour
     * 
     * @param myContext
     * @return
     */
    protected Context createForkContext(final Context myContext) {
        return new ForkContext(myContext, this);
    }

    public ForkedBehaviourProcess(final Context myContext, final String assemblyContextID, final boolean isAsync,
            final int priority) {
        this(myContext, assemblyContextID, isAsync);
        setPriority(priority);
    }

    @Override
    protected void internalLifeCycle() {
        executeBehaviour();
        this.isTerminated = true;

        // if this has been synchronous call of the behaviour and the parent has
        // not yet terminated (which may happen under some wired conditions) and
        // the simulation is still running, we can think about triggering the
        // parent again.
        if (!isAsync && !parentProcess.isTerminated() && simulationIsRunning()) {
            parentProcess.scheduleAt(0);
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Asynch behaviour finished at simtime "
                        + getModel().getSimulationControl().getCurrentSimulationTime());
            }
        }
    }

    private boolean simulationIsRunning() {
        return this.myContext.getModel().getSimulationControl().isRunning();
    }

    /**
     * Template method filled by the generate with the parallel behaviour specified in the PCM's
     * fork action
     */
    protected abstract void executeBehaviour();

    public boolean isAsync() {
        return isAsync;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simulation.abstractsimengine.SimProcess#isTerminated ()
     */
    @Override
    public boolean isTerminated() {
        return this.isTerminated;
    }

}
