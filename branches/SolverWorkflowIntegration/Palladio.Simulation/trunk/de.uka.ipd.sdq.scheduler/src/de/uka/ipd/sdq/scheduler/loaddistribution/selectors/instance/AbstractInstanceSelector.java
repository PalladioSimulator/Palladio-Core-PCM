package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;


public abstract class AbstractInstanceSelector implements IInstanceSelector {
	
	protected SimActiveResource resource;
	
	public AbstractInstanceSelector(SimActiveResource resource) {
		super();
		this.resource = resource;
	}


}
