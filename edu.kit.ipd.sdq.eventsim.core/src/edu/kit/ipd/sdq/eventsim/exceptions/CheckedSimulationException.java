package edu.kit.ipd.sdq.eventsim.exceptions;

/**
 * Checked exceptions need to be handled by the simulation. Use this exception type if the exception
 * can be handled in such a way that the simulation can proceed.
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class CheckedSimulationException extends Exception {

    private static final long serialVersionUID = 772822455058755236L;

    public CheckedSimulationException() {
        super();
    }

    public CheckedSimulationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedSimulationException(String message) {
        super(message);
    }

    public CheckedSimulationException(Throwable cause) {
        super(cause);
    }

}
