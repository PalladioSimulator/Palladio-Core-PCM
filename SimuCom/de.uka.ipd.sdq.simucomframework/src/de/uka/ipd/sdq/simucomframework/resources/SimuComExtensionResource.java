package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class SimuComExtensionResource extends AbstractActiveResource {
	
	public SimuComExtensionResource(int capacity, String name, String id) {
		super(capacity, name, id);
	}

	public abstract void initialize(SimuComModel simuComModel);

}
