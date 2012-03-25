package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.instance;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IInstanceSelector;


public abstract class AbstractInstanceSelector implements IInstanceSelector {
	
	protected SimActiveResource resource;
	
	public AbstractInstanceSelector(SimActiveResource resource) {
		super();
		this.resource = resource;
	}


}
