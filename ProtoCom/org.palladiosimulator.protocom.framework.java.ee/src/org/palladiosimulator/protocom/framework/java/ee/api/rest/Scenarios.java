package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/scenarios")
public class Scenarios {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getScenarios() {
		return "[]";
	}
}