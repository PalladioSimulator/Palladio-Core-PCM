package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.experiment.ExperimentManager;

@Path("/experiment")
public class Experiment {
	@GET
	@Path("test")
	public Response init() {
		ExperimentManager.getInstance().init("Experiment");
		ExperimentManager.getInstance().startRun();
		ExperimentManager.getInstance().takeMeasurement("Test Measurement", 100, 700);
		ExperimentManager.getInstance().stopRun();

		return Response.ok().build();
	}

	@GET
	@Path("start")
	public Response startExperiment() {
		ExperimentManager.getInstance().startRun();

		return Response.noContent().build();
	}

	@GET
	@Path("stop")
	public Response stopExperiment() {
		ExperimentManager.getInstance().stopRun();

		return Response.noContent().build();
	}
}
