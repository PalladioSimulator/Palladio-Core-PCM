package de.uka.ipd.sdq.simucomframework;

import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import desmoj.core.simulator.SimProcess;

public abstract class Context extends StackContext {

	private ResouceRegistry registry = null;
	// AssemblyContextID -> ResourceContainer Object (Deployment Link)
	private HashMap<String, SimulatedResourceContainer> assemblyLinkHash = new HashMap<String, SimulatedResourceContainer>();

	private SimProcess myThread = null;
	private SimuComModel myModel = null;
	
	public Context(SimuComModel myModel) {
		if (myModel != null) { // This is for the prototype mapping, where we don't need resources
			this.registry = myModel.getResourceRegistry();
			this.myModel = myModel;
			initialiseAssemblyContextLookup();
		} else {
			stack.createAndPushNewStackFrame();
		}
	}

	public SimulatedResourceContainer findResource(String assemblyContextID) {
		SimulatedResourceContainer container = assemblyLinkHash
				.get(assemblyContextID);
		return container;
	}

	protected void linkAssemblyContextAndResourceContainer(
			String assemblyContextID, String resourceContainerID) {
		assert registry.containsResourceContainer(resourceContainerID);
		SimulatedResourceContainer container = registry
				.getResourceContainer(resourceContainerID);
		assemblyLinkHash.put(assemblyContextID, container);
	}

	protected abstract void initialiseAssemblyContextLookup();

	public SimProcess getThread() {
		return myThread;
	}

	public SimuComModel getModel() {
		return myModel;
	}

	
	public void setSimProcess(SimProcess process) {
		this.myThread = process;
	}
}
