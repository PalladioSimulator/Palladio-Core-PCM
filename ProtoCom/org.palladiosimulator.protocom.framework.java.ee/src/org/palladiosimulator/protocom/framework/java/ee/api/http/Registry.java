package org.palladiosimulator.protocom.framework.java.ee.api.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.api.http.data.RegistryData;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;

/**
 * API class for managing the registry.
 * @author Christian Klaussner
 */
@Path("/registry")
public class Registry {
	/**
	 * Gets the location of the registry.
	 * @return a JSON object containing the location of the registry
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocation() {
		RegistryData data = new RegistryData();
		data.setLocation(org.palladiosimulator.protocom.framework.java.ee.protocol.Registry.getInstance().getLocation());

		return Response.ok(JsonHelper.toJson(data)).build();
	}

	/**
	 * Sets the location of the registry.
	 * @param raw a string containing the location of the registry
	 * @return an HTTP 204 response if the location was set successfully
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setLocation(String raw) {
		RegistryData data = (RegistryData) JsonHelper.fromJson(raw, RegistryData.class);
		org.palladiosimulator.protocom.framework.java.ee.protocol.Registry.getInstance().setLocation(data.getLocation());

		return Response.noContent().build();
	}
}
