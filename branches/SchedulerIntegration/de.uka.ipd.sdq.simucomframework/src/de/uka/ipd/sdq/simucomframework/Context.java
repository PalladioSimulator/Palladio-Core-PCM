package de.uka.ipd.sdq.simucomframework;

import java.util.HashMap;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerNotFound;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

/**
 * Context of each simulation thread. This context inherits a stack context
 * and enriches it with information on the simulated execution environment.
 * @author Steffen Becker
 *
 */
public abstract class Context extends StackContext {

	/**
	 * Central registry which contains all simulated resources 
	 */
	private ResourceRegistry registry = null;

	/**
	 * AssemblyContextID -> ResourceContainer Object (Deployment Link)
 	 */
	private HashMap<String, AbstractSimulatedResourceContainer> assemblyLinkHash = new HashMap<String, AbstractSimulatedResourceContainer>();

	/**
	 * AssemblyContextID -> PassiveRessource
 	 */
	private HashMap<String, IPassiveResource> assemblyPassiveResourceHash = new HashMap<String, IPassiveResource>();
	
	/**
	 * The thread to which this context belongs 
	 */
	private SimProcess myThread = null;
	
	/**
	 * Simulation model
	 */
	private SimuComModel myModel = null;
	
	/**
	 * Initialise a new context for the given simulation model
	 * @param myModel The simulation model used in this context
	 */
	public Context(SimuComModel myModel) {
		if (myModel != null) { // This is for the prototype mapping, where we don't need resources
			this.registry = myModel.getResourceRegistry();
			this.myModel = myModel;
			initialiseAssemblyContextLookup();
		} else {
			stack.createAndPushNewStackFrame();
		}
	}

	/**
	 * Lookup method to find the resource container in which the given components assembly
	 * context is deployed
	 * @param assemblyContextID The ID of the assembly context for which its deployment is
	 * queried
	 * @return The resource container in which the given assembly context is deployed
	 */
	public AbstractSimulatedResourceContainer findResource(String assemblyContextID) {
		AbstractSimulatedResourceContainer container = assemblyLinkHash
				.get(assemblyContextID);
		if (container == null)
			throw new ResourceContainerNotFound("Resource container for assembly context "+assemblyContextID+" not found. Check your allocation model.");
		return container;
	}

	/**
	 * Create a deployment relationship between the given assembly context and
	 * the given resource container
	 * @param assemblyContextID ID of the assembly context to allocate
	 * @param resourceContainerID ID of the resource container on which the assembly context is allocated
	 */
	protected void linkAssemblyContextAndResourceContainer(
			String assemblyContextID, String resourceContainerID) {
		assert registry.containsResourceContainer(resourceContainerID);
		AbstractSimulatedResourceContainer container = registry
				.getResourceContainer(resourceContainerID);
		assemblyLinkHash.put(assemblyContextID, container);
	}

	public IPassiveResource getPassiveRessourceInContext(
			String assemblyContextID, String passiveResourceID, AbstractSimulatedResourceContainer resourceContainer, int capacity) {
		IPassiveResource pr = assemblyPassiveResourceHash.get(assemblyContextID + passiveResourceID);
		
		if (pr == null){
			pr = ((SimulatedResourceContainer) resourceContainer).createPassiveResource(passiveResourceID, capacity);
			assemblyPassiveResourceHash.put(assemblyContextID + passiveResourceID, pr);
		}
		
		return pr;
	}

	/**
	 * Template method to be filled in by the generator. Calles
	 * linkAssemblyContextAndResourceContainer to create the
	 * deployment specified in the allocation model 
	 */
	protected abstract void initialiseAssemblyContextLookup();

	public SimProcess getThread() {
		return myThread;
	}

	public void setSimProcess(SimProcess process) {
		this.myThread = process;
	}
	
	public SimuComModel getModel() {
		return myModel;
	}
	
	public Object evaluateStoEx(String stoEx, Class<?> resultClass){
		return this.evaluate(this.myModel.getStoExCache(), stoEx, resultClass);
	}

	public Object evaluateStoEx(String stoEx){
		return this.evaluate(this.myModel.getStoExCache(), stoEx);
	}	

	public void evaluateInner(SimulatedStackframe<Object>stackFrame, String stoEx){
		this.evaluateInner(this.myModel.getStoExCache(), stackFrame, stoEx);
	}

	public Object evaluateStoEx(String stoex,
			SimulatedStackframe<Object> stackFrame) {
		return this.evaluate(this.myModel.getStoExCache(), stoex, stackFrame);
	}	
	
}
