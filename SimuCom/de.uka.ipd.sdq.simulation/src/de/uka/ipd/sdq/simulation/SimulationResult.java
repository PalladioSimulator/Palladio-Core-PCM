package de.uka.ipd.sdq.simulation;

/**
 * Status enum signaling simulation success or failure
 * 
 * @author Steffen Becker
 *
 */
public enum SimulationResult {
    /**
     * Simulation caused an error most likely by raising an exception
     */
    ERROR,

    /**
     * Simulation terminated successfully
     */
    OK;
}
