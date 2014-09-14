package org.palladiosimulator.protocom.framework.java.ee.modules;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Signals that a module was not able to start.
 * @author Christian Klaussner
 */
public class ModuleStartException extends WebApplicationException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new ModuleStartException object.
	 */
	public ModuleStartException() {
		super(Response
			.status(Response.Status.BAD_REQUEST)
			.build()
		);
	}
}
