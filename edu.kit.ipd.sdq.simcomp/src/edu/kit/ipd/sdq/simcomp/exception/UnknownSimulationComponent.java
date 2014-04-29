package edu.kit.ipd.sdq.simcomp.exception;

/**
 * This exception represents an access to a simulation component which has never
 * been registered at the simulation middleware.
 * 
 * @author Christoph Föhrdes
 */
public class UnknownSimulationComponent extends RuntimeException {

	public UnknownSimulationComponent(String message) {
		super(message);
	}

	private static final long serialVersionUID = -9102865644205018048L;

}
