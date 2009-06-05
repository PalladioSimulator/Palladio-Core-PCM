package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

/**
 * Indicates the current state of a PCM processing resource.
 * 
 * @author brosch
 * 
 */
public enum ProcessingResourceState {

	/**
	 * The resource is fully functional.
	 */
	OK,

	/**
	 * The resource is broken down.
	 */
	NA,
}
