package org.palladiosimulator.protocom.framework.jee.servlet.registry;

/**
 * Signals that an invalid request was performed at a registry.
 * @author Christian Klaussner
 */
public class RegistryException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new RegistryException object.
	 * @param message the detail message
	 */
	public RegistryException(String message) {
		super(message);
	}
}
