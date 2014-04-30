package edu.kit.ipd.sdq.eventsim.exceptions;

/**
 * Unchecked exceptions do not need to be handled by the simulation. They abort the simulation, if
 * they are not handled. Use this exception type if it is not possible to recover from an exception.
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class UncheckedSimulationException extends RuntimeException {

    private static final long serialVersionUID = -5255465543240897539L;

    public UncheckedSimulationException() {
        super();
    }

    public UncheckedSimulationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedSimulationException(String message) {
        super(message);
    }

    public UncheckedSimulationException(Throwable cause) {
        super(cause);
    }

}
