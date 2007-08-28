package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessRegistry;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimActiveResource extends AbstractSimResource implements
		IActiveResource {

	private IScheduler scheduler;
	private List<IResourceInstance> instanceList;
	private ProcessRegistry processRegistry;

	public SimActiveResource(int capacity, String name, String id,
			IScheduler scheduler) {
		super(capacity, name, id);
		this.scheduler = scheduler;
		this.instanceList = new ArrayList<IResourceInstance>();
		this.processRegistry = new ProcessRegistry();
		for (int i = 0; i < capacity; i++) {
			instanceList.add(factory.createResourceInstance(i,this));
		}
	}

	public IScheduler getScheduler() {
		return scheduler;
	}

	public List<IResourceInstance> getInstanceList() {
		return instanceList;
	}

	public IActiveProcess lookUp(ISchedulableProcess process) {
		return processRegistry.lookUp(process);
	}

	@Override
	public void process(ISchedulableProcess sched_process, double demand) {
		IActiveProcess process = processRegistry.lookUp(sched_process);
		assert MathTools.equalsDouble(process.getCurrentDemand(), 0) : "Demand of Process "
				+ process
				+ " must be processed completely before adding a new demand!";
		process.setCurrentDemand(demand);
		scheduler.scheduleNextEvent(process.getLastInstance());
		sched_process.passivate();
	}

	/**
	 * Before a process can issue demands to the resource it needs to be
	 * registered. After registration the process is blocked.
	 * 
	 * @param process
	 *            Process to execute on the resource.
	 */
	public void registerNewProcess(IRunningProcess process) {
		processRegistry.registerProcess((IActiveProcess) process);
		scheduler.addProcess((IActiveProcess) process);
		process.getSchedulableProcess().passivate();
	}

	public void start() {
		for (IResourceInstance instance : this.instanceList) {
			scheduler.scheduleNextEvent(instance);
		}
	}

	public boolean isIdle(IResourceInstance instance) {
		return this.scheduler.isIdle(instance);
	}
}
