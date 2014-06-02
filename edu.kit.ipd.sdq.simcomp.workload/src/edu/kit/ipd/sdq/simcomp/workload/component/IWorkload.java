package edu.kit.ipd.sdq.simcomp.workload.component;

import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;
import edu.kit.ipd.sdq.simcomp.workload.events.WorkloadUserFinished;
import edu.kit.ipd.sdq.simcomp.workload.events.WorkloadUserSpawn;

/**
 * Represents a workload simulation component which generates calls to services
 * of an {@link ISystem} simulation component.
 * 
 * @author Christoph Föhrdes
 */
public interface IWorkload extends ISimulationComponent {

	/**
	 * List of simulation events triggered by this simulation component.
	 */
	@SuppressWarnings("rawtypes")
	public static Class[] componentEvents = new Class[] { 
		WorkloadUserSpawn.class, 
		WorkloadUserFinished.class
	};

	/**
	 * Starts the workload generation.
	 */
	public void generate();
}
