package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;


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
