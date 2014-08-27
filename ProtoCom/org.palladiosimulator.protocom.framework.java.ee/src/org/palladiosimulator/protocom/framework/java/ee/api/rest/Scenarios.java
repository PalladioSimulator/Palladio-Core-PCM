package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.prototype.IUsageScenario;
import org.palladiosimulator.protocom.framework.java.ee.prototype.Prototype;

import com.sun.jersey.core.header.ContentDisposition;

/**
 *
 * @author Christian Klaussner
 */
@Path("/scenarios")
public class Scenarios {

	/**
	 *
	 * @param id
	 * @return
	 */
	private static IUsageScenario getScenario(String id) {
		Prototype prototype = Prototype.getInstance();

		for (IUsageScenario scenario : prototype.getUsageScenarios()) {
			if (scenario.getId().equals(id)) {
				return scenario;
			}
		}

		return null;
	}

	/**
	 *
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getScenarios() {
		Prototype prototype = Prototype.getInstance();
		return Response.ok(JsonHelper.toJson(prototype.getUsageScenarios())).build();
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadScenario(@PathParam("id") String id) {
		IUsageScenario scenario;

		if ((scenario = getScenario(id)) != null) {
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
