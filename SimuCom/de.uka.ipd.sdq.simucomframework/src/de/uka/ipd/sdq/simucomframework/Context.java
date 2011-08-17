package de.uka.ipd.sdq.simucomframework;

import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerNotFound;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import desmoj.core.simulator.SimProcess;

public abstract class Context extends StackContext {

	private ResourceRegistry registry = null;
	// AssemblyContextID -> ResourceContainer Object (Deployment Link)
	private HashMap<String, AbstractSimulatedResourceContainer> assemblyLinkHash = new HashMap<String, AbstractSimulatedResourceContainer>();

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

	public AbstractSimulatedResourceContainer findResource(String assemblyContextID) {
		AbstractSimulatedResourceContainer container = assemblyLinkHash
				.get(assemblyContextID);
		if (container == null)
			throw new ResourceContainerNotFound("Resource container for assembly context "+assemblyContextID+" not found. Check your allocation model.");
		return container;
	}

	protected void linkAssemblyContextAndResourceContainer(
			String assemblyContextID, String resourceContainerID) {
		assert registry.containsResourceContainer(resourceContainerID);
		AbstractSimulatedResourceContainer container = registry
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
