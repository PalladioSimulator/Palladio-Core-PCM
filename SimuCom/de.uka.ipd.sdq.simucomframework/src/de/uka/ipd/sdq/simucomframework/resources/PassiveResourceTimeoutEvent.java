package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * This event indicates a timeout of a process waiting at a passive resource.
 * 
 * @author brosch
 * 
 */
public class PassiveResourceTimeoutEvent<M extends ISimulationModel<M>> extends AbstractSimEvent<M, SimpleWaitingProcess<M>> {

	/**
	 * The waiting process.
	 */
	private SimpleWaitingProcess<M> process;

	/**
	 * The resource.
	 */
	private SimSimpleFairPassiveResource<M> resource;

	/**
	 * Creates a new timeout event.
	 * 
	 * @param model
	 *            the SimuCom model
	 * @param resource
	 *            the involved passive resource
	 * @param process
	 *            the waiting process
	 */
	public PassiveResourceTimeoutEvent(final M model,
			final SimSimpleFairPassiveResource<M> resource,
			final SimpleWaitingProcess<M> process) {
		super(model, resource.getName());
		this.resource = resource;
		this.process = process;
	}

	private static int count = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent#eventRoutine
	 * (de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate)
	 */
	public void eventRoutine(SimpleWaitingProcess<M> who) {

		// Check if the process is still waiting:
		if (!resource.isWaiting(process)) {
			return;
		}

		// Trigger a timeout of the waiting process:
		resource.remove(process);
		process.getProcess().timeout(
				FailureStatistics.getInstance().getResourceTimeoutFailureType(
						resource.getAssemblyContextID(),
						resource.getPassiveResourceID()).getId());
	}

	/**
	 * Retrieves the waiting process.
	 * 
	 * @return the waiting process
	 */
	public SimpleWaitingProcess<M> getProcess() {
		return process;
	}

	/**
	 * Retrieves the passive resource.
	 * 
	 * @return the passive resource
	 */
	public SimSimpleFairPassiveResource<M> getResource() {
		return resource;
	}

}
