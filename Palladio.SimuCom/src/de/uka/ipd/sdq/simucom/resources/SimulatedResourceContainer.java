package de.uka.ipd.sdq.simucom.resources;

import java.util.HashMap;
import java.util.Iterator;

import PalladioCM.ResourceEnvironmentPackage.ProcessingResourceSpecification;
import PalladioCM.ResourceEnvironmentPackage.ResourceContainer;
import PalladioCM.ResourceTypePackage.ProcessingResourceType;
import de.uka.ipd.sdq.simucom.SimuComModel;

public class SimulatedResourceContainer {

	protected HashMap<String,SimulatedActiveResource> containedActiveResources = new HashMap<String,SimulatedActiveResource>();
	
	public SimulatedResourceContainer(SimuComModel myModel, ResourceContainer container)
	{
		Iterator resources = container.getActiveResourceSpecifications_ResourceContainer().iterator();
		while(resources.hasNext())
		{
			ProcessingResourceSpecification newSpec = (ProcessingResourceSpecification)resources.next();
			containedActiveResources.put( 
					newSpec.getActiveResourceType_ActiveResourceSpecification().getId(),
					new SimulatedActiveResource(myModel,newSpec));
		}
	}
	
	public void activateAllActiveResources()
	{
		for (SimulatedActiveResource activeRes : containedActiveResources.values())
			activeRes.activateResource();
	}
	
	public SimulatedActiveResource getActiveResource(ProcessingResourceType type)
	{
		return containedActiveResources.get(type.getId());
	}
}
