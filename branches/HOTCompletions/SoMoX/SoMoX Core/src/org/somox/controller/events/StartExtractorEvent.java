package org.somox.controller.events;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;

/**
 * Event to start the extractors
 *
 * @author Benjamin Klatt
 *
 */
public class StartExtractorEvent extends CoreControllerEvent {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The preferences connected to this events */
	private Preferences preferences = null;

	// ---------------------------------
	// Constructor
	// ---------------------------------

	public StartExtractorEvent(IProgressMonitor progressMonitor, Preferences preferences) {
		super(progressMonitor);
		this.setPreferences(preferences);
	}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	/**
	 * @param preferences the preferences to set
	 */
	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
	}

	/**
	 * @return the preferences
	 */
	public Preferences getPreferences() {
		return preferences;
	}

}
