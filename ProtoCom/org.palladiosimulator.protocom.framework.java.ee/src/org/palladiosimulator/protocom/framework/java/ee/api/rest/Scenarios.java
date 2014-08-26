package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.prototype.IUsageScenario;

import com.sun.jersey.core.header.ContentDisposition;

/**
 *
 * @author Christian Klaussner
 */
@Path("/scenarios")
public class Scenarios {
	private static List<IUsageScenario> scenarios = loadScenarios();

	/**
	 *
	 * @param className
	 * @return
	 */
	private static IUsageScenario scenarioFromClass(String className) {
		String name = "usagescenarios." + className.substring(0, className.lastIndexOf('.'));

		try {
			return (IUsageScenario) Class.forName(name).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 *
	 * @return
	 */
	private static List<IUsageScenario> loadScenarios() {
		List<IUsageScenario> results = new LinkedList<IUsageScenario>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		try {
			Enumeration<URL> resources = classLoader.getResources("/usagescenarios");

			if (resources.hasMoreElements()) {
				File folder = new File(resources.nextElement().getFile());

				for (File file : folder.listFiles()) {
					if (file.isFile()) {
						results.add(scenarioFromClass(file.getName()));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return results;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	private static IUsageScenario getScenario(String id) {
		for (IUsageScenario scenario : scenarios) {
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
		return Response.ok(JsonHelper.toJson(scenarios)).build();
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
