package de.uka.ipd.sdq.simulation.exceptions;

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
