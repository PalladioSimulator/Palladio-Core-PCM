package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.api.rest.data.RegistryData;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;

@Path("/registry")
public class Registry {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocation() {
		RegistryData data = new RegistryData();
		data.setLocation(org.palladiosimulator.protocom.framework.java.ee.protocol.Registry.getInstance().getLocation());

		return Response.ok(JsonHelper.toJson(data)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setLocation(String raw) {
		RegistryData data = (RegistryData) JsonHelper.fromJson(raw, RegistryData.class);
		org.palladiosimulator.protocom.framework.java.ee.protocol.Registry.getInstance().setLocation(data.getLocation());

		return Response.noContent().build();
	}
}
