package de.uka.ipd.sdq.simucomframework.resources;

import java.util.ArrayDeque;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import de.uka.ipd.sdq.scheduler.processes.SimpleWaitingProcess;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.passive.PassiveResourceObservee;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Simulates a simple passive resource.
 *
 * Note: This class intentionally does not extend {@link SimAbstractPassiveResource}, because that
 * abstract class is intended for passive resources that are accessed by EXACT schedulers (e.g.,
 * specific Windows, Linux Scheduler).
 *
 * TODO: comment
 *
 * TODO Initialize based on given model elements [Lehrig]
 *
 * @author Fabro, Sebastian Lehrig
 *
 * @param <M>
 *            the type of the simulation model.
 */
public class SimSimpleFairPassiveResource extends AbstractSimResource implements IPassiveResource {

    protected Queue<IWaitingProcess> waitingQueue;
    private final SchedulerModel myModel;
    private long available;
    private final String passiveResourceID;
    private final boolean simulateFailures;
    private final SimuComModel simuComModel;

    // provides observer functionality to this resource
    private final PassiveResourceObservee observee;
    private final PassiveResource resource;
    private final AssemblyContext assemblyContext;

    public SimSimpleFairPassiveResource(final PassiveResource resource, final AssemblyContext assemblyContext,
            final SimuComModel simuComModel, final Long capacity) {
        super(simuComModel, capacity, resource.getEntityName(), resource.getId() + ":" + assemblyContext.getId());
        this.resource = resource;
        this.assemblyContext = assemblyContext;

        this.simuComModel = simuComModel;
        this.waitingQueue = new ArrayDeque<IWaitingProcess>();
        this.myModel = simuComModel;
        this.passiveResourceID = resource.getId();
        this.observee = new PassiveResourceObservee();
        this.available = capacity;
        this.simulateFailures = simuComModel.getConfiguration().getSimulateFailures();
    }

    private boolean canProceed(final ISchedulableProcess process, final long num) {
        return (waitingQueue.isEmpty() || waitingQueue.peek().getProcess().equals(process)) && num <= available;
    }

    @Override
    public PassiveResource getResource() {
        return this.resource;
    }

    @Override
    public AssemblyContext getAssemblyContext() {
        return this.assemblyContext;
    }

    @Override
    public Queue<IWaitingProcess> getWaitingProcesses() {
        return waitingQueue;
    }

    private void grantAccess(final ISchedulableProcess process, final long num) {
        LoggingWrapper.log("Process " + process + " acquires " + num + " of " + this);
        this.available -= num;
        observee.fireAquire(process, num);
        assert this.available >= 0 : "More resource than available have been acquired!";
    }

    @Override
    public boolean acquire(final ISchedulableProcess schedulableProcess, final long num, final boolean timeout,
            final double timeoutValue) {

        // AM: Copied from AbstractActiveResource: If simulation is stopped,
        // allow all processes to finish
        if (!myModel.getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return true;
        }
        // TODO
        // Do we need some logic here to check if the simulation has stopped?
        // In this case, this method should not block, but return in order to
        // allow processes to complete
        observee.fireRequest(schedulableProcess, num);
        if (canProceed(schedulableProcess, num)) {
            grantAccess(schedulableProcess, num);
            return true;
        } else {
            LoggingWrapper.log("Process " + schedulableProcess + " is waiting for " + num + " of " + this);
            final SimpleWaitingProcess process = new SimpleWaitingProcess(myModel, schedulableProcess, num);
            processTimeout(timeout, timeoutValue, process);
            waitingQueue.add(process);
            schedulableProcess.passivate();
            return false;
        }
    }

    /**
     * Schedules a timeout event if a timeout is specified and failures are simulated.
     *
     * @param timeout
     *            indicates if the acquire request is associated with a timeout
     * @param timeoutValue
     *            the timeout value
     * @param process
     *            the waiting process
     */
    private void processTimeout(final boolean timeout, final double timeoutValue, final SimpleWaitingProcess process) {
        if (!simulateFailures || !timeout) {
            return;
        }
        if (timeoutValue == 0.0) {
            FailureException.raise(
                    simuComModel,
                    simuComModel.getFailureStatistics().getResourceTimeoutFailureType(this.assemblyContext.getId(),
                            this.passiveResourceID));
        }
        if (timeoutValue > 0.0) {
            final PassiveResourceTimeoutEvent event = new PassiveResourceTimeoutEvent(simuComModel, myModel, this,
                    process);
            event.schedule(process, timeoutValue);
        }
    }

    /**
     * Retrieves the passive resource ID.
     *
     * @return the passive resource ID
     */
    protected String getPassiveResourceID() {
        return passiveResourceID;
    }

    @Override
    public void release(final ISchedulableProcess schedulableProcess, final long num) {

        // AM: Copied from AbstractActiveResource: If simulation is stopped,
        // allow all processes to finish
        if (!myModel.getSimulationControl().isRunning()) {
            // Do nothing, but allows calling process to complete
            return;
        }

        LoggingWrapper.log("Process " + schedulableProcess + " releases " + num + " of " + this);
        this.available += num;
        observee.fireRelease(schedulableProcess, num);
        notifyWaitingProcesses();
    }

    private void notifyWaitingProcesses() {
        SimpleWaitingProcess waitingProcess = (SimpleWaitingProcess) waitingQueue.peek();
        while (waitingProcess != null && canProceed(waitingProcess.getProcess(), waitingProcess.getNumRequested())) {
            grantAccess(waitingProcess.getProcess(), waitingProcess.getNumRequested());
            waitingQueue.remove();
            waitingProcess.getProcess().activate();
            waitingProcess = (SimpleWaitingProcess) waitingQueue.peek();
        }
    }

    @Override
    public void addObserver(final IPassiveResourceSensor observer) {
        observee.addObserver(observer);
    }

    @Override
    public void removeObserver(final IPassiveResourceSensor observer) {
        observee.removeObserver(observer);
    }

    @Override
    public long getAvailable() {
        return available;
    }

    /**
     * Determines if a given process is currently waiting to acquire this resource.
     *
     * @param process
     *            the process
     * @return TRUE if the process is waiting to acquire the resource; FALSE otherwise
     */
    public boolean isWaiting(final SimpleWaitingProcess process) {
        return waitingQueue.contains(process);
    }

    /**
     * Removes a waiting process from the queue.
     *
     * @param process
     *            the process to remove
     */
    public void remove(final SimpleWaitingProcess process) {
        waitingQueue.remove(process);
    }
}