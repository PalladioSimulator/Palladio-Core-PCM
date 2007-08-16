package de.uka.ipd.sdq.scheduler.resources.scheduler;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.ProcessRegistry;
import de.uka.ipd.sdq.scheduler.resources.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IQueueingStrategy;

public abstract class AbstractScheduler implements IScheduler {

	protected SimActiveResource resource;

	protected ProcessRegistry processRegistry;

	protected IQueueingStrategy queueingStrategy;
	
	public AbstractScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy) {
		super();
		this.resource = resource;
		this.queueingStrategy = queueingStrategy;
	}

	public abstract void schedule(SimResourceInstance instance);

	@Override
	public void registerProcess(ActiveProcess process) {
		processRegistry.registerProcess(process);
		queueingStrategy.addProcess(process);
	}
}
