package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/registry")
public class Registry {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getLocation() {
		return "{}";
	}
	
	@POST
	public void postLocation(String data) {
	}
}
