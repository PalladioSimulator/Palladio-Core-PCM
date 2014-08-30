package org.palladiosimulator.protocom.framework.java.ee.modules;

/**
 * Signals that a module was not able to start.
 * @author Christian Klaussner
 */
public class ModuleStartException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new ModuleStartException object.
	 */
	public ModuleStartException() {
		super();
	}
}
