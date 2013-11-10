package de.uka.ipd.sdq.simucomframework;

import java.util.HashMap;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerNotFound;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Context of each simulation thread. This context inherits a stack context and
 * enriches it with information on the simulated execution environment.
 * 
 * @author Steffen Becker
 * 
 */
public abstract class Context extends StackContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1869414754329617190L;

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
	private SimuComSimProcess myThread = null;

	/**
	 * Simulation model
	 */
	private SimuComModel myModel = null;

	/**
	 * Initialise a new context for the given simulation model
	 * 
	 * @param myModel
	 *            The simulation model used in this context
	 */
	public Context(SimuComModel myModel) {
		if (myModel != null) { // This is for the prototype mapping, where we
			// don't need resources
			this.registry = myModel.getResourceRegistry();
			this.myModel = myModel;
			initialiseAssemblyContextLookup();
		} else {
			stack.createAndPushNewStackFrame();
		}
	}

	public long getSessionId() {
		return myThread.getCurrentSessionId();
	}

	/**
	 * Lookup method to find the resource container in which the given
	 * components assembly context is deployed
	 * 
	 * @param assemblyContextID
	 *            The ID of the assembly context for which its deployment is
	 *            queried
	 * @return The resource container in which the given assembly context is
	 *         deployed
	 */
	public AbstractSimulatedResourceContainer findResource(
			String assemblyContextID) {
		AbstractSimulatedResourceContainer container = assemblyLinkHash
				.get(assemblyContextID);
		if (container == null)
			throw new ResourceContainerNotFound(
					"Resource container for assembly context "
							+ assemblyContextID
							+ " not found. Check your allocation model. "
							+ "Note that a SubSystem must only be used once in one System, using one several times may cause this error. ");
		return container;
	}

	/**
	 * Lookup method to find the linking resource container that belongs to the
	 * given container id.
	 * 
	 * @param linkingResourceContainerID
	 *            the container id
	 * @return the linking resource container
	 */
	public SimulatedLinkingResourceContainer findLinkingResource(
			String linkingResourceContainerID) {
		AbstractSimulatedResourceContainer container = registry
				.getResourceContainer(linkingResourceContainerID);
		if ((container == null)
				|| !(container instanceof SimulatedLinkingResourceContainer)) {
			throw new ResourceContainerNotFound(
					"Linking resource container for container ID "
							+ linkingResourceContainerID + " not found.");
		}
		return (SimulatedLinkingResourceContainer) container;
	}

	/**
	 * Create a deployment relationship between the given assembly context and
	 * the given resource container
	 * 
	 * @param assemblyContextID
	 *            ID of the assembly context to allocate
	 * @param resourceContainerID
	 *            ID of the resource container on which the assembly context is
	 *            allocated
	 */
	protected void linkAssemblyContextAndResourceContainer(
			String assemblyContextID, String resourceContainerID) {
		assert registry.containsResourceContainer(resourceContainerID);
		AbstractSimulatedResourceContainer container = registry
				.getResourceContainer(resourceContainerID);
		assemblyLinkHash.put(assemblyContextID, container);
	}

	public IPassiveResource getPassiveRessourceInContext(
			String assemblyContextID, String passiveResourceName,
			String passiveResourceID,
			AbstractSimulatedResourceContainer resourceContainer, int capacity) {
		IPassiveResource pr = assemblyPassiveResourceHash.get(assemblyContextID
				+ passiveResourceID);

		if (pr == null) {
			pr = ((SimulatedResourceContainer) resourceContainer)
					.createPassiveResource(passiveResourceName,
							passiveResourceID, assemblyContextID,
							passiveResourceID + ":" + assemblyContextID,
							capacity);
			assemblyPassiveResourceHash.put(assemblyContextID
					+ passiveResourceID, pr);
		}

		return pr;
	}

	/**
	 * Template method to be filled in by the generator. Calles
	 * linkAssemblyContextAndResourceContainer to create the deployment
	 * specified in the allocation model
	 */
	protected abstract void initialiseAssemblyContextLookup();

	public SimuComSimProcess getThread() {
		return myThread;
	}

	public void setSimProcess(SimuComSimProcess process) {
		this.myThread = process;
	}

	public SimuComModel getModel() {
		return myModel;
	}

}
