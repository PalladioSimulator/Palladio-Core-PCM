package org.palladiosimulator.protocom.framework.java.ee.api.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.prototype.IUsageScenario;
import org.palladiosimulator.protocom.framework.java.ee.prototype.PrototypeBridge;

import com.sun.jersey.core.header.ContentDisposition;

/**
 * API class for retrieving usage scenario data.
 * @author Christian Klaussner
 */
@Path("/scenarios")
public class Scenarios {
	@Inject
	private PrototypeBridge bridge;

	/**
	 * Gets the usage scenario for the specified ID.
	 * @param id the ID of the usage scenario
	 * @return the IUsageScenario instance of the usage scenario
	 */
	private IUsageScenario getScenario(String id) {
		for (IUsageScenario scenario : bridge.getUsageScenarios()) {
			if (scenario.getId().equals(id)) {
				return scenario;
			}
		}

		return null;
	}

	/**
	 * Gets all usage scenarios.
	 * @return a JSON array containing information about all usage scenarios
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getScenarios() {
		return Response.ok(JsonHelper.toJson(bridge.getUsageScenarios())).build();
	}

	/**
	 * Gets the JXM file of the specified usage scenario.
	 * @param id the ID of the usage scenario
	 * @return an octet stream containing the JXM file
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadScenario(@PathParam("id") String id) {
		IUsageScenario scenario = getScenario(id);

		if (scenario != null) {
			try {
				InputStream in = scenario.getFileUrl().openStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();

				IOUtils.copy(in, out);

				ContentDisposition disposition = ContentDisposition
					.type("attachement")
					.fileName(scenario.getFileName())
					.build();

				return Response
					.ok(out.toByteArray())
					.header("Content-Disposition", disposition)
					.build();

			} catch (IOException e) {
				e.printStackTrace();
				return Response.serverError().build();
			}
		} else {
			return Response.serverError().build();
		}
	}
}
