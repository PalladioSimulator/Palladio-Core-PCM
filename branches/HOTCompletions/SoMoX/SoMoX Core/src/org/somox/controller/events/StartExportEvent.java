package org.somox.controller.events;

import org.eclipse.core.runtime.IProgressMonitor;


/**
 * Start the export event
 *
 * @author Benjamin Klatt
 *
 */
public class StartExportEvent extends CoreControllerEvent {

	public StartExportEvent(IProgressMonitor progressMonitor) {
		super(progressMonitor);
	}

}
