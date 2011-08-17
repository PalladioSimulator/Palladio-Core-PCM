package de.uka.ipd.sdq.scheduler.resources.passive;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;

/**
 * @author Fabro
 * 
 * Simulates a simple passive resource.
 * 
 * Note:
 *   This class intentionally does not extend {@link SimAbstractPassiveResource}, because that
 *   abstract class is intended for passive resources that are accessed by EXACT schedulers
 *   (e.g., specific Windows, Linux Scheduler).
 * 
 * TODO: comment
 */
public class SimSimpleFairPassiveResource extends AbstractSimResource implements IPassiveResource {

	protected Deque<_SimpleWaitingProcess> waiting_queue;
	
	private int available;
	
	// provides observer functionality to this resource
	private PassiveResourceObservee observee;
	
	public SimSimpleFairPassiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
		this.waiting_queue = new ArrayDeque<_SimpleWaitingProcess>();
		observee = new PassiveResourceObservee();
		available = capacity;
	}

	private boolean canProceed(ISchedulableProcess process, int num) {
		return (waiting_queue.isEmpty() || waiting_queue.peek().getProcess().equals(process))
				&& num <= available;
	}
	
	private void grantAccess(ISchedulableProcess process, int num) {
		LoggingWrapper.log("Process " + process 
				+ " acquires " + num + " of " + this);
		this.available -= num;
		observee.fireAquire(process, num);
		assert this.available >= 0 : "More resource than available have been acquired!";
	}
	
	public boolean acquire(ISchedulableProcess sched_process, int num) {
		
		//AM: Copied from AbstractActiveResource: If simulation is stopped, allow all processes to finish
		if (SchedulingFactory.getUsedSimulator().isStopped()) {
			// Do nothing, but allows calling process to complete
			return true;
		}
		//TODO
		//Do we need some logic here to check if the simulation has stopped?
		//In this case, this method should not block, but return in order to allow processes to complete
		observee.fireRequest(sched_process, num);
		if (canProceed(sched_process, num)) {
			grantAccess(sched_process, num);
			return true;
		} else {
			LoggingWrapper.log("Process " + sched_process 
					+ " is waiting for " + num + " of " + this);
			waiting_queue.add( new _SimpleWaitingProcess(sched_process, num) );
			sched_process.passivate();
			return false;
		}
	}

	public void release(ISchedulableProcess sched_process, int num) {
		
		//AM: Copied from AbstractActiveResource: If simulation is stopped, allow all processes to finish
		if (SchedulingFactory.getUsedSimulator().isStopped()) {
			// Do nothing, but allows calling process to complete
			return;
		}
		
		LoggingWrapper.log("Process " + sched_process
				+ " releases " + num + " of " + this);
		this.available += num;
		observee.fireRelease(sched_process, num);
		notifyWaitingProcesses();
	}

	private void notifyWaitingProcesses() {
		_SimpleWaitingProcess waitingProcess = waiting_queue.peek();
		while (waitingProcess != null && 
			   canProceed(waitingProcess.getProcess(), waitingProcess.getNumRequested())) {
			grantAccess(waitingProcess.getProcess(), waitingProcess.getNumRequested());
			waiting_queue.remove();
			waitingProcess.getProcess().activate();
			waitingProcess = waiting_queue.peek();
		}
	}

	@Override
	public void addObserver(IPassiveResourceSensor observer) {
		observee.addObserver(observer);
	}

	@Override
	public void removeObserver(IPassiveResourceSensor observer) {
		observee.removeObserver(observer);
	}

	@Override
	public int getAvailable() {
		return available;
	}
	
}


class _SimpleWaitingProcess {

	private ISchedulableProcess sched_process;
	private int num_requested;

	public _SimpleWaitingProcess(ISchedulableProcess sched_process, int num_requested) {
		super();
		this.sched_process = sched_process;
		this.num_requested = num_requested;
	}

	public ISchedulableProcess getProcess() {
		return sched_process;
	}

	public int getNumRequested() {
		return num_requested;
	}
}
