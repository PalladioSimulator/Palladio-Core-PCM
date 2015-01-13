package org.palladiosimulator.protocom.framework.java.ee.api.http;

import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/experiment")
public class Experiment {
	@Inject
	private org.palladiosimulator.protocom.framework.java.ee.experiment.IExperiment experiment;

	private static ConcurrentHashMap<String, Long> startTimes;
	private static String scenarioName = "Scenario";

	static {
		startTimes = new ConcurrentHashMap<String, Long>();
	}

	@PUT
	@Path("start")
	public Response startExperiment(String name) {
		scenarioName = name;

		startTimes.clear();
		experiment.startRun();

		return Response.noContent().build();
	}

	@PUT
	@Path("stop")
	public Response stopExperiment() {
		experiment.stopRun();

		return Response.noContent().build();
	}

	@PUT
	@Path("iteration/start/{id}")
	public void startIteration(@PathParam("id") String id) {
		long time = System.nanoTime();
		startTimes.put(id, time);
	}

	@PUT
	@Path("iteration/stop/{id}")
	public void stopIteration(@PathParam("id") String id) {
		long now = System.nanoTime();
		experiment.takeMeasurement(scenarioName + " Response Time", startTimes.get(id), now);

		startTimes.remove(id);
	}
}
