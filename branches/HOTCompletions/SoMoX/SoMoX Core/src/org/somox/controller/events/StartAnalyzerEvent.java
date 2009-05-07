package org.somox.controller.events;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;

/**
 * Event to start the analyzer
 *
 * @author Benjamin Klatt
 *
 */
public class StartAnalyzerEvent extends CoreControllerEvent {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The preferences connected to this events */
	private Preferences preferences = null;
	
	/** The id of the analyzer which should be started */
	private String analyzerID= null;

	// ---------------------------------
	// Constructor
	// ---------------------------------

	public StartAnalyzerEvent(String analyzerID, IProgressMonitor progressMonitor, Preferences preferences) {
		super(progressMonitor);
		this.setPreferences(preferences);
		this.analyzerID = analyzerID;
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
	
	public String getAnalyzerID() {
		return analyzerID;
	}

}
