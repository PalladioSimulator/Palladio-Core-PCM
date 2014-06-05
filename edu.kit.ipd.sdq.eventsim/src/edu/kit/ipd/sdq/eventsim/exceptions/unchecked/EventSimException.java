package edu.kit.ipd.sdq.eventsim.exceptions.unchecked;

import edu.kit.ipd.sdq.eventsim.exceptions.UncheckedSimulationException;

/**
 * This exception indicates a problem while performing an EventSim simulation run. If this exception
 * is not catched, the simulation aborts.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimException extends UncheckedSimulationException {

    private static final long serialVersionUID = -7270433571897078637L;

    public EventSimException() {
        super();
    }

    public EventSimException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventSimException(String message) {
        super(message);
    }

    public EventSimException(Throwable cause) {
        super(cause);
    }

}
