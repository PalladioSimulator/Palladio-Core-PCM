package org.somox.controller.impl;

import org.somox.controller.SoMoXCoreControllerListener;
import org.somox.controller.events.CoreControllerEvent;
import org.somox.controller.events.StartAnalyzerEvent;
import org.somox.controller.events.StartExportEvent;
import org.somox.controller.events.StartExtractorEvent;
import org.somox.core.SoMoXCore;

/**
 * Listener Implementation to control the SoMoX Core
 *
 * @author Benjamin Klatt
 *
 */
public class SoMoXCoreListenerImpl implements SoMoXCoreControllerListener {

	/** The SoMoX Core to work with */
	private SoMoXCore somoxCore = null;


	/** Constructor requiring the SoMoX Core */
	public SoMoXCoreListenerImpl(SoMoXCore somoxCore) {
		this.somoxCore = somoxCore;
	}

	/**
	 * Handle the start extractor event
	 *
	 * @param event
	 */
	public void handle(StartExtractorEvent event) {
		this.somoxCore.runExtraction(event.getProgressMonitor(),event.getPreferences());
	}

	/**
	 * Handle the start analyzer event
	 *
	 * @param event The event object
	 */
	public void handle(StartAnalyzerEvent event) {
		this.somoxCore.runAnalyzer(event.getAnalyzerID(), event.getProgressMonitor(),event.getPreferences());
	}

	/**
	 * Handle the start export event
	 *
	 * @param event The event object
	 */
	public void handle(StartExportEvent event) {
		this.somoxCore.runExport(event.getProgressMonitor());
	}

	/**
	 * General handler method for the core controller events
	 * @param	event The event to handle
	 * @return	The result of the event
	 */
	public void handle(CoreControllerEvent event) {
		if (event instanceof StartExtractorEvent) {
			handle((StartExtractorEvent) event);

		} else if (event instanceof StartAnalyzerEvent) {
			handle((StartAnalyzerEvent) event);

		} else if (event instanceof StartExportEvent) {
			handle((StartExportEvent) event);
		}
	}

}
