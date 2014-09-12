package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/experiment")
public class Experiment {
	@Inject
	private org.palladiosimulator.protocom.framework.java.ee.experiment.Experiment experiment;

	@GET
	@Path("start")
	public Response startExperiment() {
		experiment.startRun();

		return Response.noContent().build();
	}

	@GET
	@Path("stop")
	public Response stopExperiment() {
		experiment.stopRun();

		return Response.noContent().build();
	}
}
