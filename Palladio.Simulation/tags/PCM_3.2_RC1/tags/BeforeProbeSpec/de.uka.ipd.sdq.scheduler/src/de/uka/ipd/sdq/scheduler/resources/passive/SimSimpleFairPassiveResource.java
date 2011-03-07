package de.uka.ipd.sdq.scheduler.resources.passive;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;

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
	
	public SimSimpleFairPassiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
		this.waiting_queue = new ArrayDeque<_SimpleWaitingProcess>();
	}

	private boolean canProceed(ISchedulableProcess process, int num) {
		return (waiting_queue.isEmpty() || waiting_queue.peek().getProcess().equals(process))
				&& num <= capacity;
	}
	
	private void grantAccess(ISchedulableProcess process, int num) {
		LoggingWrapper.log("Process " + process 
				+ " acquires " + num + " of " + this);
		this.capacity -= num;
		assert this.capacity >= 0 : "More resource than available have been acquired!";
	}
	
	public boolean acquire(ISchedulableProcess sched_process, int num) {
		//TODO
		//Do we need some logic here to check if the simulation has stopped?
		//In this case, this method should not block, but return in order to allow processes to complete
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
		LoggingWrapper.log("Process " + sched_process
				+ " releases " + num + " of " + this);
		this.capacity += num;
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
