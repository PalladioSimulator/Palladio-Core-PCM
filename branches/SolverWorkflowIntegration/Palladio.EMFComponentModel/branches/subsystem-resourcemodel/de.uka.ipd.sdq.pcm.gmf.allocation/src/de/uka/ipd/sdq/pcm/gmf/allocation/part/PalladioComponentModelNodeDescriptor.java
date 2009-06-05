/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class PalladioComponentModelNodeDescriptor {

	/**
	 * @generated
	 */
	private EObject myModelElement;

	/**
	 * @generated
	 */
	private int myVisualID;

	/**
	 * @generated
	 */
	private String myType;

	/**
	 * @generated
	 */
	public PalladioComponentModelNodeDescriptor(EObject modelElement,
			int visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}

	/**
	 * @generated
	 */
	public EObject getModelElement() {
		return myModelElement;
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return myVisualID;
	}

	/**
	 * @generated
	 */
	public String getType() {
		if (myType == null) {
			myType = PalladioComponentModelVisualIDRegistry
					.getType(getVisualID());
		}
		return myType;
	}

}
