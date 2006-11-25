package de.uka.ipd.sdq.simucom;

import java.util.HashMap;

public abstract class Context {

	private ResouceRegistry registry = ResouceRegistry.singleton();
	
	// AssemblyContextID -> ResourceContainer Object (Deployment Link)
	private HashMap<String, SimulatedResourceContainer> assemblyLinkHash = new HashMap<String, SimulatedResourceContainer>();
	
	public Context()
	{
		initialiseResourceContainer();
		initialiseAssemblyContextLookup();
	}
	
	public int evaluate(String string) {
		return 10;
	}

	public SimulatedResourceContainer findResource(String assemblyContextID, String resourceTypeID) {
		SimulatedResourceContainer container = assemblyLinkHash.get(assemblyContextID);
		return container;
	}

	protected void linkAssemblyContextAndResourceContainer(String assemblyContextID, String resourceContainerID)
	{
		assert registry.containsResourceContainer(resourceContainerID);
		SimulatedResourceContainer container = registry.getResourceContainer(resourceContainerID);
		assemblyLinkHash.put(assemblyContextID, container);
	}
	
	protected SimulatedResourceContainer createResourceContainer(String containerID) {
		return registry.createResourceContainer(containerID);
	}
	
	protected abstract void initialiseAssemblyContextLookup();
	protected abstract void initialiseResourceContainer();
}
