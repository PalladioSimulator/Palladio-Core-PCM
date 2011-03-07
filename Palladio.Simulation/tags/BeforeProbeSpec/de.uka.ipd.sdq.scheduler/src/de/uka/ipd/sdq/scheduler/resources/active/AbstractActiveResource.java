package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;

public abstract class AbstractActiveResource extends AbstractSimResource
		implements IActiveResource {

	private static Map<ISchedulableProcess, AbstractActiveResource> currentResourceTable = new ConcurrentHashMap<ISchedulableProcess, AbstractActiveResource>();

	public AbstractActiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
	}

	public final void process(ISchedulableProcess process, double demand) {
		// what should actually happen here is a test of SSJExperiment.isRunning
		if (SchedulingFactory.getUsedSimulator().isStopped()) {
			// Do nothing, but allows calling process to complete
			return;
		}

		AbstractActiveResource last = getLastResource(process);
		if (!this.equals(last)) {
			if (last != null) {
				last.dequeue(process);
			}
			this.enqueue(process);
			setLastResource(process, this);
		}
		doProcessing(process, demand);
	}

	protected abstract void doProcessing(ISchedulableProcess process,
			double demand);

	protected abstract void enqueue(ISchedulableProcess process);

	protected abstract void dequeue(ISchedulableProcess process);

	private static AbstractActiveResource getLastResource(
			ISchedulableProcess process) {
		return currentResourceTable.get(process);
	}

	private static void setLastResource(ISchedulableProcess process,
			AbstractActiveResource resource) {
		if (!currentResourceTable.containsKey(process)) {
			process.addTerminatedObserver(resource);
		}
		currentResourceTable.put(process, resource);
	}

	public static void cleanProcesses() {
		// Activate all waiting processes to yield process completion
		// Synchronization with process() avoids that processes are added after
		// the activation.
		for (ISchedulableProcess process : currentResourceTable.keySet()) {
			if (!process.isFinished()) {
				process.activate();
			}
		}

		// assert that all threads have been terminated.
		assert currentResourceTable.size() == 0;
	}

	@Override
	public void notifyTerminated(ISchedulableProcess simProcess) {
		currentResourceTable.remove(simProcess);
	}

}
