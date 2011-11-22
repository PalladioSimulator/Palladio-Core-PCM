package de.uka.ipd.sdq.simucomframework.resources;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.passive.PassiveResourceObservee;
import de.uka.ipd.sdq.scheduler.resources.passive.SimAbstractPassiveResource;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * @author Fabro
 * 
 *         Simulates a simple passive resource.
 * 
 *         Note: This class intentionally does not extend
 *         {@link SimAbstractPassiveResource}, because that abstract class is
 *         intended for passive resources that are accessed by EXACT schedulers
 *         (e.g., specific Windows, Linux Scheduler).
 * 
 *         TODO: comment
 *         
 * @param <M>
 *            the type of the simulation model.
 */
public class SimSimpleFairPassiveResource<M extends ISimulationModel<M>> extends AbstractSimResource implements
		IPassiveResource {

	protected Deque<SimpleWaitingProcess<M>> waiting_queue;
	private M myModel;
	private int available;
	private String passiveResourceID;
	private String assemblyContextID;
	private boolean simulateFailures;

	// provides observer functionality to this resource
	private PassiveResourceObservee observee;

    public SimSimpleFairPassiveResource(M model, int capacity, String name, String passiveResourceID,
            String assemblyContextID, String combinedID, boolean simulateFailures) {
		super(capacity, name, combinedID);
		this.waiting_queue = new ArrayDeque<SimpleWaitingProcess<M>>();
		this.myModel = model;
		this.passiveResourceID = passiveResourceID;
		this.assemblyContextID = assemblyContextID;
		this.observee = new PassiveResourceObservee();
		this.available = capacity;
		this.simulateFailures = simulateFailures;
	}

	private boolean canProceed(ISchedulableProcess process, int num) {
		return (waiting_queue.isEmpty() || waiting_queue.peek().getProcess()
				.equals(process))
				&& num <= available;
	}

	private void grantAccess(ISchedulableProcess process, int num) {
		LoggingWrapper.log("Process " + process + " acquires " + num + " of "
				+ this);
		this.available -= num;
		observee.fireAquire(process, num);
		assert this.available >= 0 : "More resource than available have been acquired!";
	}

	public boolean acquire(ISchedulableProcess sched_process, int num,
			boolean timeout, double timeoutValue) {

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
		observee.fireRequest(sched_process, num);
		if (canProceed(sched_process, num)) {
			grantAccess(sched_process, num);
			return true;
		} else {
			LoggingWrapper.log("Process " + sched_process + " is waiting for "
					+ num + " of " + this);
			SimpleWaitingProcess<M> process = new SimpleWaitingProcess<M>(
			        myModel, sched_process, num);
			processTimeout(timeout, timeoutValue, process);
			waiting_queue.add(process);
			sched_process.passivate();
			return false;
		}
	}

	/**
	 * Schedules a timeout event if a timeout is specified and failures are
	 * simulated.
	 * 
	 * @param timeout
	 *            indicates if the acquire request is associated with a timeout
	 * @param timeoutValue
	 *            the timeout value
	 * @param process
	 *            the waiting process
	 */
	private void processTimeout(final boolean timeout,
			final double timeoutValue, final SimpleWaitingProcess<M> process) {
        if (!simulateFailures || !timeout) {
            return;
        }
		if (timeoutValue == 0.0) {
			FailureException.raise(FailureStatistics.getInstance()
					.getResourceTimeoutFailureType(this.assemblyContextID,
							this.passiveResourceID));
		}
        if (timeoutValue > 0.0) {
            PassiveResourceTimeoutEvent<M> event = new PassiveResourceTimeoutEvent<M>(myModel, this, process);
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

	/**
	 * Retrieves the assembly context ID.
	 * 
	 * @return the assembly context ID
	 */
	protected String getAssemblyContextID() {
		return assemblyContextID;
	}

	public void release(ISchedulableProcess sched_process, int num) {

		// AM: Copied from AbstractActiveResource: If simulation is stopped,
		// allow all processes to finish
		if (!myModel.getSimulationControl().isRunning()) {
			// Do nothing, but allows calling process to complete
			return;
		}

		LoggingWrapper.log("Process " + sched_process + " releases " + num
				+ " of " + this);
		this.available += num;
		observee.fireRelease(sched_process, num);
		notifyWaitingProcesses();
	}

	private void notifyWaitingProcesses() {
		SimpleWaitingProcess<M> waitingProcess = waiting_queue.peek();
		while (waitingProcess != null
				&& canProceed(waitingProcess.getProcess(), waitingProcess
						.getNumRequested())) {
			grantAccess(waitingProcess.getProcess(), waitingProcess
					.getNumRequested());
			waiting_queue.remove();
			waitingProcess.getProcess().activate();
			waitingProcess = waiting_queue.peek();
		}
	}

	public void addObserver(IPassiveResourceSensor observer) {
		observee.addObserver(observer);
	}

	public void removeObserver(IPassiveResourceSensor observer) {
		observee.removeObserver(observer);
	}

	public int getAvailable() {
		return available;
	}

	/**
	 * Determines if a given process is currently waiting to acquire this
	 * resource.
	 * 
	 * @param process
	 *            the process
	 * @return TRUE if the process is waiting to acquire the resource; FALSE
	 *         otherwise
	 */
	public boolean isWaiting(final SimpleWaitingProcess<M> process) {
		return waiting_queue.contains(process);
	}

	/**
	 * Removes a waiting process from the queue.
	 * 
	 * @param process
	 *            the process to remove
	 */
	public void remove(final SimpleWaitingProcess<M> process) {
		waiting_queue.remove(process);
	}
}