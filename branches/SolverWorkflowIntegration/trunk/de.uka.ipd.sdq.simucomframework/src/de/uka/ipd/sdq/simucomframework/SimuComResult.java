package de.uka.ipd.sdq.simucomframework;

/**
 * Status enum signaling simulation success or failure
 * @author Steffen Becker
 *
 */
public enum SimuComResult {
	/**
	 * Simulation caused an error most likely by raising an exception 
	 */
	ERROR, 
	
	/**
	 * Simulation terminated successfully
	 */
	OK; 
}
