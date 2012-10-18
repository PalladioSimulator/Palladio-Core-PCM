/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import org.eclipse.emf.ecore.EObject;

/**
 * The Class PalladioComponentModelNodeDescriptor.
 *
 * @generated
 */
public class PalladioComponentModelNodeDescriptor {

    /** The my model element. @generated */
    private final EObject myModelElement;

    /** The my visual id. @generated */
    private final int myVisualID;

    /**
     * Instantiates a new palladio component model node descriptor.
     *
     * @param modelElement the model element
     * @param visualID the visual id
     * @generated
     */
    public PalladioComponentModelNodeDescriptor(EObject modelElement, int visualID) {
        myModelElement = modelElement;
        myVisualID = visualID;
    }

    /**
     * Gets the model element.
     *
     * @return the model element
     * @generated
     */
    public EObject getModelElement() {
        return myModelElement;
    }

    /**
     * Gets the visual id.
     *
     * @return the visual id
     * @generated
     */
    public int getVisualID() {
        return myVisualID;
    }

}
