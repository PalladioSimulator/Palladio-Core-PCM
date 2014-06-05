package edu.kit.ipd.sdq.eventsim.exceptions.unchecked;

import org.eclipse.emf.ecore.EClass;

import edu.kit.ipd.sdq.eventsim.exceptions.UncheckedSimulationException;

/**
 * This exception indicates that the PCM model has an unexpected structure.
 * 
 * @author Philipp Merkle
 * 
 */
public class UnexpectedModelStructureException extends UncheckedSimulationException {

    private static final long serialVersionUID = 283182632907523529L;

    /**
     * Use this constructor to indicate a problem which is described in the specified message.
     * 
     * @param message
     *            the problem description
     */
    public UnexpectedModelStructureException(String message) {
        super(message);
    }

    /**
     * Use this constructor to indicate that a certain class is expected, but another class was
     * found.
     * 
     * @param expected
     *            the expected class
     * @param found
     *            the class that was actually found
     */
    public UnexpectedModelStructureException(EClass expected, EClass found) {
        super("Expected an object of type " + expected.eClass().getName() + " but found an object of type "
                + found.eClass().getName());
    }

}
