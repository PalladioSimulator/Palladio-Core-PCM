package de.uka.ipd.sdq.simucomframework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.palladiosimulator.probeframework.measurement.RequestContext;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.resources.active.SimDelayResource;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simulation.SimulationResult;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcessListener;

public abstract class SimuComSimProcess extends AbstractSimProcessDelegator implements ISchedulableProcess,
ISimProcessListener {

    private static AtomicLong sessionID = new AtomicLong(0);
    /** Logger for this class. */
    protected static Logger logger = Logger.getLogger(SimuComSimProcess.class.getName());

    private Process processStatus = null;
    private SimDelayResource delayResource = null;

    private final boolean isDebug;

    private final List<IActiveResource> removedObservers = new ArrayList<IActiveResource>();;

    private final RequestContext requestContext;

    private final ArrayList<IActiveResource> terminatedObservers = new ArrayList<IActiveResource>();

    protected long currentSessionId;

    private boolean isTimeoutFailure = false;

    private String timeoutFailureTypeId = null;

    private int priority = 0;

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(final int priority) {
        this.priority = priority;
    }

    protected SimuComSimProcess(final SimuComModel model, final String name) {
        this(model, name, null);
    }

    protected SimuComSimProcess(final SimuComModel model, final String name, final RequestContext parentRequestContext) {
        super(model, name);
        this.isDebug = model.getConfiguration().isDebug();
        this.delayResource = new SimDelayResource(model, name + "_thinktime", name + "_thinktime");
        requestContext = new RequestContext(Long.valueOf(getRawId()).toString(), parentRequestContext);

        // add a process listener in order to get notified when this process is about to be
        // suspended or resumed again.
        this.addProcessListener(this);

        if(logger.isDebugEnabled()) {
            logger.debug("Create SimuComSimProcess with id " + getRawId());
        }
    }

    @Override
    public void activate() {
        this.scheduleAt(0);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * de.uka.ipd.sdq.scheduler.ISchedulableProcess#timeout(java.lang.String)
     */
    @Override
    public void timeout(final String timeoutFailureTypeId) {
        this.isTimeoutFailure = true;
        this.timeoutFailureTypeId = timeoutFailureTypeId;
        activate();
    };

    /**
     * Clients may override default behaviour, e.g., PassiveResource
     */
    protected void addProcessToSimStatus() {
        if(logger.isDebugEnabled()) {
            logger.debug("Starting simulation process " + this.getName());
        }

        if (isDebug) {
            processStatus = SimucomstatusFactory.eINSTANCE.createProcess();
            this.getModel().getSimulationStatus().getProcessStatus()
            .getProcesses().add(processStatus);
            processStatus.setId(this.getName());
            processStatus.setProcessStartTime(this.getModel()
                    .getSimulationControl().getCurrentSimulationTime());
        }
    }

    @Override
    public void addTerminatedObserver(final IActiveResource r) {
        if (!terminatedObservers.contains(r)){
            terminatedObservers.add(r);
        }
    }

    @Override
    public void fireTerminated() {
        LoggingWrapper.log("Process " + this.getId() + " terminated.");
        for (final IActiveResource activeResource : terminatedObservers) {
            activeResource.notifyTerminated(this);
        }
        terminatedObservers.removeAll(removedObservers);
        removedObservers.clear();
    }

    // Strategy dependent methods

    public long getCurrentSessionId() {
        return currentSessionId;
    }

    /**
     * Returns the {@link RequestContext} in which this simulated process is
     * executed.
     *
     * @return the request context
     */
    public RequestContext getRequestContext() {
        return requestContext;
    }

    @Override
    public ISchedulableProcess getRootProcess(){
        // TODO: What is expected here?
        return null;
    }

    public Process getSimProcessStatus() {
        return this.processStatus;
    }

    public void hold(final double d) {
        delayResource.process(this, 1, Collections.<String, Serializable> emptyMap(), d);
    }

    protected abstract void internalLifeCycle();

    @Override
    public boolean isFinished() {
        return isTerminated();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * de.uka.ipd.sdq.simulation.abstractsimengine.ISimProcessDelegate
     * #lifeCycle()
     */
    @Override
    public final void lifeCycle() {
        addProcessToSimStatus();
        try {
            this.internalLifeCycle();
        } catch (final Exception e) {
            String message = e.getMessage();
            message = message == null ? "" : message;
            if (e instanceof IllegalArgumentException && message.contains("Cannot schedule in the past")){
                if(logger.isEnabledFor(Level.WARN)) {
                    logger.warn(
                            "Simulation caused an exception because it scheduled in the past. Check your models that you do not have any negative demands, arrival times, or similar",
                            e);
                }
            }
            else {
                if(logger.isEnabledFor(Level.WARN)) {
                    logger.warn(
                            "Simulation caused an exception. Caught it in SimProcess Lifecycle Method",
                            e);
                }
            }
            getModel().setStatus(SimulationResult.ERROR, e);
            if(logger.isDebugEnabled()) {
                logger.debug("Trying to stop simulation now...");
            }
            this.getModel().getSimulationControl().stop();
        }
        // TODO: Activate
        // resultProbe.takeMeasurement(requestContext);
        this.fireTerminated();
        removeProcessFromSimStatus();
    }

    /**
     *
     */
    protected void removeProcessFromSimStatus() {
        if(logger.isDebugEnabled()) {
            logger.debug("Terminating SimuComSimProcess " + this.getName());
        }
        if (isDebug) {
            this.getModel().getSimulationStatus().getProcessStatus()
            .getProcesses().remove(processStatus);
        }
    }

    @Override
    public void removeTerminatedObserver(final IActiveResource r) {
        removedObservers.remove(r);
    }

    protected void updateNewSessionID() {
        currentSessionId = sessionID.incrementAndGet();
    }

    @Override
    public void notifyResuming(final ISimProcess process) {
        // the process is about to resume again. Check for the timeout
        // failure condition:
        if (this.isTimeoutFailure) {
            // reset timeout failure
            this.isTimeoutFailure = false;
            FailureException.raise(this.getModel(),this.getModel().getFailureStatistics().getFailureType(timeoutFailureTypeId));
        }
    }

    @Override
    public void notifySuspending(final ISimProcess process) {
        // nothing to do here
    }

    @Override
    public void notifyTerminated(final ISimProcess process) {
        // nothing to do here
    }

    @Override
    public SimuComModel getModel() {
        return (SimuComModel) super.getModel();
    }


}
