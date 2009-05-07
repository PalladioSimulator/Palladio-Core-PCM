package org.somox.controller;

import org.somox.controller.events.CoreControllerEvent;

/**
 * Listener for SoMoX Controller Events
 *
 * @author Benjamin Klatt
 *
 */
public interface SoMoXCoreControllerListener {

	/**
	 * Handle the core controller event
	 *
	 * @param event The event to handle
	 */
	public void handle(CoreControllerEvent event);
}
