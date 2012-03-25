package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.instance;

import java.util.Iterator;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;


public class RoundRobinSelector extends AbstractInstanceSelector {
	
	Iterator<IResourceInstance> instance_iterator;

	public RoundRobinSelector(SimActiveResource resource) {
		super(resource);
		reset();
	}

	public IResourceInstance selectInstanceFor(IActiveProcess process, IResourceInstance running_on) {
		IResourceInstance result = null;
		while(result == null){
			IResourceInstance current = getNext();
			if (process.checkAffinity(current)){
				result = current;
				if (!process.hasIdealInstance()){
					process.setIdealInstance(current);
				}
			}
		}
		return result;
	}

	private IResourceInstance getNext() {
		if (!instance_iterator.hasNext())
			reset();
		return instance_iterator.next();
	}

	private void reset() {
		instance_iterator = resource.getInstanceList().iterator();
	}
}
