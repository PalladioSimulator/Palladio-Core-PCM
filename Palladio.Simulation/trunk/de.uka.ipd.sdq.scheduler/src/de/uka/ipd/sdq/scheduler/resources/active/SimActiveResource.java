package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
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

	public static final Logger logger = Logger.getLogger("Scheduler");

	public SimActiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
		this.instanceList = new ArrayList<IResourceInstance>();
		this.processRegistry = new ProcessRegistry();
		for (int i = 0; i < capacity; i++) {
			instanceList.add(factory.createResourceInstance(i, this));
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
		
		LoggingWrapper.log(" Process " + process + " demands "
				+ MathTools.round(demand, 0.01));
		
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
			instance.start();
		}
	}

	public boolean isIdle(IResourceInstance instance) {
		return this.scheduler.isIdle(instance);
	}

	public void setScheduler(IScheduler scheduler) {
		this.scheduler = scheduler;
	}

}
