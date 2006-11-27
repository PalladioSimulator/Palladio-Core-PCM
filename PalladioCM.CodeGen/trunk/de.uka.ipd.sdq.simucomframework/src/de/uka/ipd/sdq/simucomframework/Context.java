package de.uka.ipd.sdq.simucomframework;

import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import desmoj.core.simulator.SimProcess;

public abstract class Context {

	private ResouceRegistry registry = null;
	
	// AssemblyContextID -> ResourceContainer Object (Deployment Link)
	private HashMap<String, SimulatedResourceContainer> assemblyLinkHash = new HashMap<String, SimulatedResourceContainer>();

	private SimProcess myThread = null;
	
	public Context(SimuComModel myModel, SimProcess myThread)
	{
		this.registry = myModel.getResourceRegistry();
		this.myThread  = myThread;
		initialiseResourceContainer();
		initialiseAssemblyContextLookup();
	}
	
	public int evaluate(String string) {
		return 10;
	}

	public SimulatedResourceContainer findResource(String assemblyContextID) {
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

	public SimProcess getThread() {
		return myThread;
	}
}
