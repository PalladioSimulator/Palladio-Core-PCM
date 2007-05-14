package de.uka.ipd.sdq.simucom.resources;

import java.util.HashMap;
import java.util.Iterator;

import de.uka.ipd.sdq.pcm.resourceenvironment.PassiveResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.PassiveResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.simucom.SimuComModel;

public class SimulatedResourceContainer {

	protected HashMap<String,SimulatedActiveResource> containedActiveResources = new HashMap<String,SimulatedActiveResource>();
	protected HashMap<String,SimulatedPassiveResource> containedPassiveResources = new HashMap<String,SimulatedPassiveResource>();
	
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

		resources = container.getPassiveResourceSpecifications_ResourceContainer().iterator();
		while(resources.hasNext())
		{
			PassiveResourceSpecification newSpec = (PassiveResourceSpecification)resources.next();
			containedPassiveResources.put( 
					newSpec.getPassiveResourceType_PassiveResourceSpecification().getId(),
					new SimulatedPassiveResource(myModel,newSpec));
		}
	}
	
	public void activateAllActiveResources()
	{
		for (SimulatedActiveResource activeRes : containedActiveResources.values())
			activeRes.activateResource();
		for (SimulatedPassiveResource passiveRes : containedPassiveResources.values())
			passiveRes.activateResource();
	}
	
	public SimulatedActiveResource getActiveResource(ProcessingResourceType type)
	{
		return containedActiveResources.get(type.getId());
	}

	public SimulatedPassiveResource getPassiveResource(PassiveResourceType type) {
		return containedPassiveResources.get(type.getId());
	}
}
