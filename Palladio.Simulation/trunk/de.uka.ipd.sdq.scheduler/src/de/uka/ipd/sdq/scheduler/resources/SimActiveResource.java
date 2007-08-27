package de.uka.ipd.sdq.scheduler.resources;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.ProcessRegistry;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimActiveResource extends AbstractSimResource implements
		IActiveResource {

	private IScheduler scheduler;
	private List<SimResourceInstance> instanceList;
	private ProcessRegistry processRegistry;

	public SimActiveResource(int capacity, String name, String id,
			IScheduler scheduler) {
		super(capacity, name, id);
		this.scheduler = scheduler;
		this.instanceList = new ArrayList<SimResourceInstance>();
		this.processRegistry = new ProcessRegistry();
		for (int i = 0; i < capacity; i++) {
			instanceList.add(factory.createResourceInstance(i, name, id,
					scheduler));
		}
	}

	public IScheduler getScheduler() {
		return scheduler;
	}

	public List<SimResourceInstance> getInstanceList() {
		return instanceList;
	}
	
	public ActiveProcess lookUp(ISchedulableProcess process){
		return processRegistry.lookUp(process);
	}

	@Override
	public void process(ISchedulableProcess sched_process, double demand) {
		ActiveProcess process = processRegistry.lookUp(sched_process);
		assert MathTools.equalsDouble(process.getCurrentDemand(), 0) : "Demand of Process "
				+ process
				+ " must be processed completely before adding a new demand!";
		process.setCurrentDemand(demand);
		scheduler.scheduleNextEvent(process.getLastInstance());
		sched_process.passivate();
	}

	/**
	 * Before a process can process demands on the resource it needs to be
	 * registered.
	 */
	public void registerNewProcess(ActiveProcess process) {
		processRegistry.registerProcess(process);
		scheduler.addProcess(process);
	}
}
