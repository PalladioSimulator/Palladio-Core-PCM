package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Indicates the current state of a PCM processing resource.
 * 
 * @author brosch
 * 
 */
public enum MarkovResourceState {

    /**
     * The resource is broken down.
     */
    NA,

    /**
     * The resource is fully functional.
     */
    OK,
}
