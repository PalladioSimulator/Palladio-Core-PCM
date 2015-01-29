package org.palladiosimulator.protocom.framework.java.ee.api.http;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 * API class for resetting the prototype status to "initial". Only for debugging purposes!
 * @author Christian Klaussner
 */
@Path("/reset")
public class Reset {
	@Context
	private ServletContext context;

	/**
	 * Resets the prototype status to "initial".
	 */
	@GET
	public void reset() {
		context.setAttribute("status", "initial");
	}
}
