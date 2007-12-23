package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;


public class AbstractInstanceSelector implements IInstanceSelector {
	
	protected SimActiveResource resource;
	
	public AbstractInstanceSelector(SimActiveResource resource) {
		super();
		this.resource = resource;
	}


	public IResourceInstance selectInstanceFor(IActiveProcess process) {
		return null;
	}
}
