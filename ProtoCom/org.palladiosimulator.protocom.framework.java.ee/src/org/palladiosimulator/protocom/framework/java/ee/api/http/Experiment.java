package org.palladiosimulator.protocom.framework.java.ee.api.http;

import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * API class for controlling experiments and experiment iterations.
 * @author Christian Klaussner
 */
@Path("/experiment")
public class Experiment {
	@Inject
	private org.palladiosimulator.protocom.framework.java.ee.experiment.IExperiment experiment;

	private static final ConcurrentHashMap<String, Long> START_TIMES;
	private static String scenarioName = "Scenario";

	static {
		START_TIMES = new ConcurrentHashMap<String, Long>();
	}

	/**
	 * Starts an experiment with the specified name.
	 * @param name the name of the experiment
	 * @return an HTTP 204 response if the experiment was started successfully
	 */
	@PUT
	@Path("start")
	public Response startExperiment(String name) {
		scenarioName = name;

		START_TIMES.clear();
		experiment.startRun();

		return Response.noContent().build();
	}

	/**
	 * Stops the currently running experiment.
	 * @return an HTTP 204 response if the experiment was stopped successfully
	 */
	@PUT
	@Path("stop")
	public Response stopExperiment() {
		experiment.stopRun();

		return Response.noContent().build();
	}

	/**
	 * Starts an experiment iteration.
	 * @param id the ID of the iteration
	 */
	@PUT
	@Path("iteration/start/{id}")
	public void startIteration(@PathParam("id") String id) {
		long time = System.nanoTime();
		START_TIMES.put(id, time);
	}

	/**
	 * Stops an experiment iteration.
	 * @param id the ID of the iteration
	 */
	@PUT
	@Path("iteration/stop/{id}")
	public void stopIteration(@PathParam("id") String id) {
		long now = System.nanoTime();
		experiment.takeMeasurement(scenarioName + " Response Time", START_TIMES.get(id), now);

		START_TIMES.remove(id);
	}
}
