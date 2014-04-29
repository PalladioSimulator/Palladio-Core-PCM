package edu.kit.ipd.sdq.simcomp.component;

/**
 * Represents a workload simulation component which generates calls to services
 * of an {@link ISystem} simulation component.
 * 
 * @author Christoph Föhrdes
 */
public interface IWorkload extends ISimulationComponent {

	/**
	 * Starts the workload generation.
	 */
	public void generate();
}
