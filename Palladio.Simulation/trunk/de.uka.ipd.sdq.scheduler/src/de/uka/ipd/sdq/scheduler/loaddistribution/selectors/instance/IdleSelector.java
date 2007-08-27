package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;


public class IdleSelector extends AbstractInstanceSelector  {

	RoundRobinSelector ideal_instance_selector;
	
	public IdleSelector(MultipleQueuesStrategy queue_holder) {
		super(queue_holder);
		ideal_instance_selector = new RoundRobinSelector(queue_holder);
	}

	@Override
	public IResourceInstance selectInstanceFor(IActiveProcess process) {
		List<IResourceInstance> idleInstances = queue_holder.getIdleInstances();
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

	private void selectIdealInstance(IActiveProcess process) {
		ideal_instance_selector.selectInstanceFor(process);
	}
}
