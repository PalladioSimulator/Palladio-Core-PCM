package de.uka.ipd.sdq.simucom.resources;

import java.util.HashMap;
import java.util.Iterator;

import de.uka.ipd.sdq.simucom.SimuComModel;

import PalladioCM.ResourceEnvironmentPackage.ResourceContainer;
import PalladioCM.ResourceEnvironmentPackage.ResourceEnvironment;

public class SimulatedResources {

	protected HashMap<String,SimulatedResourceContainer> resources = new HashMap<String,SimulatedResourceContainer>();
	
	public SimulatedResources(SimuComModel myModel, ResourceEnvironment resourceEnvironment) {
		Iterator resourceContainer = resourceEnvironment.getResourcecontainer().iterator();
		while (resourceContainer.hasNext())
		{
			ResourceContainer newContainer = (ResourceContainer)resourceContainer.next();
			resources.put(newContainer.getId(), new SimulatedResourceContainer(myModel, newContainer));
		}
	}

	public SimulatedResourceContainer getResourceContainer(String id)
	{
		return resources.get(id);
	}
	
	public void activateAllActiveResources()
	{
		for (SimulatedResourceContainer container : resources.values())
		{
			container.activateAllActiveResources();
		}
	}
}
