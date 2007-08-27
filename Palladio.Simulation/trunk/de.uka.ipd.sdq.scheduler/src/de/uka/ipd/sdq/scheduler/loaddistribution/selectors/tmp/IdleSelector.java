package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.tmp;

import java.util.List;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;


public class IdleSelector extends AbstractInstanceSelector  {

	RoundRobinSelector idealProcessorSelector;
	
	public IdleSelector(MultipleQueuesStrategy runQueueHolder) {
		super(runQueueHolder);
		idealProcessorSelector = new RoundRobinSelector(runQueueHolder);
	}

	@Override
	public IResourceInstance selectInstanceFor(ActiveProcess process) {
		List<IResourceInstance> idleInstances = runQueueHolder.getIdleInstances();
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
