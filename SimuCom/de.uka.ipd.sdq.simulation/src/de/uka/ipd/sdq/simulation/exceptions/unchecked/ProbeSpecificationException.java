package de.uka.ipd.sdq.simulation.exceptions.unchecked;

import de.uka.ipd.sdq.simulation.exceptions.UncheckedSimulationException;

/**
 * This exception indicates a problem with the ProbeSpecification.
 * 
 * @author Philipp Merkle
 * 
 */
public class ProbeSpecificationException extends UncheckedSimulationException {

    private static final long serialVersionUID = -3068130307767069737L;

    public ProbeSpecificationException() {
        super();
    }

    public ProbeSpecificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProbeSpecificationException(String message) {
        super(message);
    }

    public ProbeSpecificationException(Throwable cause) {
        super(cause);
    }

}
