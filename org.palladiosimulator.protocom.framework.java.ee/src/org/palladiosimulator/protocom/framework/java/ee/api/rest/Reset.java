package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/reset")
public class Reset {
	@Context
	private ServletContext context;

	@GET
	public void reset() {
		context.setAttribute("status", "initial");
	}
}
