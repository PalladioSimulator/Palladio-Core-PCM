package de.uka.ipd.sdq.scheduler.resources.balancing.instanceselectors;

import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.strategies.MultipleQueuesStrategy;


public class IdleSelector extends AbstractInstanceSelector  {

	RoundRobinSelector idealProcessorSelector;
	
	public IdleSelector(MultipleQueuesStrategy runQueueHolder) {
		super(runQueueHolder);
		idealProcessorSelector = new RoundRobinSelector(runQueueHolder);
	}

	@Override
	public SimResourceInstance selectInstanceFor(ActiveProcess process) {
		List<SimResourceInstance> idleInstances = runQueueHolder.getIdleInstances();
		process.removeNonAffineInstances(idleInstances);
		
		if (!process.hasIdealInstance())
			selectIdealInstance(process);
		
		if(!idleInstances.isEmpty()){
			if(idleInstances.contains(process.getIdealInstance())){
				return process.getIdealInstance();
			}
			if(process.hasLastInstance() && idleInstances.contains(process.getLastInstance())){
				return process.getLastInstance();
			}
			return idleInstances.get(0);
		}
		return process.getIdealInstance();
	}

	private void selectIdealInstance(ActiveProcess process) {
		idealProcessorSelector.selectInstanceFor(process);
	}
}
