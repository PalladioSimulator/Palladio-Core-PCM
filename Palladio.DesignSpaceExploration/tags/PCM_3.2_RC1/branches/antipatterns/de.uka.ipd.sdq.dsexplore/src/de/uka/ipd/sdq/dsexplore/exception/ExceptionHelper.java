package de.uka.ipd.sdq.dsexplore.exception;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;

public class ExceptionHelper {
	
	private static final String PLUGIN_ID = "de.uka.ipd.sdq.dsexplore";

	public static CoreException createNewCoreException(String message){
		return  new CoreException(new Status(Status.ERROR, PLUGIN_ID, message));
	}
	
	public static CoreException createNewCoreException(String message, Throwable cause){
		return  new CoreException(new Status(Status.ERROR, PLUGIN_ID, message, cause));
	}

	/**
	 * Could add a specific exception type here.
	 * @param message
	 * @return
	 */
	public static CoreException createNewInitialisationException(String message) {
		return createNewCoreException(message);
	}
	
	public static CoreException createNewInitialisationException(String message, Throwable cause) {
		return createNewCoreException(message, cause);
	}
}
