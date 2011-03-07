package de.uka.ipd.sdq.simulation.exceptions.concrete;

import de.uka.ipd.sdq.simulation.exceptions.UncheckedSimulationException;

public class ResourceInitialisationException extends UncheckedSimulationException {

    private static final long serialVersionUID = -9174834795490225970L;

    private static final String MESSAGE_PREFIX = "Failure while initialising the resource environment";

    public ResourceInitialisationException() {
        super();
    }

    public ResourceInitialisationException(String message) {
        super(MESSAGE_PREFIX + ": " + message);
    }

}
