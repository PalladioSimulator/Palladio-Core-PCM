package org.somox.qimpress.internalarchitecturemodel;

import org.eclipse.emf.ecore.resource.Resource;
import org.somox.model.InternalArchitectureModel.InternalArchitectureModel;

/**
 * QImpress based internal architecture model
 *
 * @author Benjamin Klatt
 *
 */
public class QImpressInternalArchitectureModel implements InternalArchitectureModel {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The list of analyzed model elements */
	private Resource model = null;

	// ---------------------------------
	// Constructor
	// ---------------------------------

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	@Override
	public Resource getModel() {
		return model;
	}

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	/**
	 * @param model the model to set
	 */
	public void setModel(Resource model) {
		this.model = model;
	}
}
