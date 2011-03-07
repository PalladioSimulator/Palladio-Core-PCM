package de.uka.ipd.sdq.simulation.exceptions.concrete;

import de.uka.ipd.sdq.simulation.exceptions.UncheckedSimulationException;

public class TraversalException extends UncheckedSimulationException {

    private static final long serialVersionUID = 3436608203944313127L;

    private static final String MESSAGE_PREFIX = "Failure while traversing";

    public TraversalException() {
        super();
    }

    public TraversalException(String message) {
        super(MESSAGE_PREFIX + ": " + message);
    }
    
}
