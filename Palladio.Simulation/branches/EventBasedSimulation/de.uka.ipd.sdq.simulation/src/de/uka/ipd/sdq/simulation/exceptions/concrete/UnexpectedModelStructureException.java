package de.uka.ipd.sdq.simulation.exceptions.concrete;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.simulation.exceptions.UncheckedSimulationException;

public class UnexpectedModelStructureException extends UncheckedSimulationException {

    private static final long serialVersionUID = 283182632907523529L;

    public UnexpectedModelStructureException(String message) {
        super(message);
    }
    
    public UnexpectedModelStructureException(EClass expected, EClass found) {
        super("Expected an object of type " + expected.eClass().getName() + " but found an object of type "
                + found.eClass().getName());
    }

    public UnexpectedModelStructureException(List<EClass> expected, EClass found) {
        // TODO!
    }

}
