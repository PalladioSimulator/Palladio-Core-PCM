package de.uka.ipd.sdq.simulation.exceptions;

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
