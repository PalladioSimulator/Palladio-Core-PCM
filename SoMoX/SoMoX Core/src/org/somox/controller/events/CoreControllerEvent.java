package org.somox.controller.events;

import org.eclipse.core.runtime.IProgressMonitor;

public class CoreControllerEvent {

	/** A process listener that takes back the information about the current process */
	private IProgressMonitor progressMonitor = null;

	/** Constructor for a controller event that requires a process listener to controll the process state */
	public CoreControllerEvent(IProgressMonitor progressMonitor){
		this.progressMonitor = progressMonitor;
	}

	/**
	 * Get the assigned process listener
	 *
	 * @return The process listener
	 */
	public IProgressMonitor getProgressMonitor() {
		return this.progressMonitor;
	}

}
