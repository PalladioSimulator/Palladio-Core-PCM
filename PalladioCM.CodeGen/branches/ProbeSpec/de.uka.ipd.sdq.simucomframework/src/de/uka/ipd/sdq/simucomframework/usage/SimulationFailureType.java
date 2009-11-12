package de.uka.ipd.sdq.simucomframework.usage;

/**
 * Denotes the type of failure that may happen during simulation due to failure
 * annotations in the model.
 * 
 * @author brosch
 * 
 */
public enum SimulationFailureType {

	/**
	 * Represents a software failure of an InternalAction.
	 */
	InternalActionFailed,

	/**
	 * Represents a message transport failure over network.
	 */
	CommunicationLinkFailed,

	/**
	 * Represents an unavailable resource.
	 */
	ResourceUnavailable,
}
