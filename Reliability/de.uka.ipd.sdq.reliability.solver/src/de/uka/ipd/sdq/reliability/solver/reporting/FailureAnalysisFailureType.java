package de.uka.ipd.sdq.reliability.solver.reporting;

/**
 * Enumeration describing the type of failure probabilities that are grouped together
 * (that is, added up) for creating a Markov reporting.
 * 
 * @author Daniel Patejdl
 * 
 */
public enum FailureAnalysisFailureType {
	/**
	 * Group together software-induced failures.
	 */
	SOFTWARE_INDUCED,

	/**
	 * Group together hardware-induced failures.
	 */
	HARDWARE_INDUCED,

	/**
	 * Group together network-induced failures.
	 */
	NETWORK_INDUCED
}
