package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.modules.ContainerModule;
import org.palladiosimulator.protocom.framework.java.ee.modules.ModuleList;
import org.palladiosimulator.protocom.framework.java.ee.modules.SystemModule;
import org.palladiosimulator.protocom.framework.java.ee.prototype.Container;
import org.palladiosimulator.protocom.framework.java.ee.prototype.Prototype;
import org.palladiosimulator.protocom.framework.java.ee.prototype.System;

@Path("/modules")
public class Modules {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getModules() {
		Prototype prototype = Prototype.getInstance();
		ModuleList modules = new ModuleList();

		// Add system to the list.

		System system = prototype.getSystem();
		modules.add(new SystemModule("1", system.getName(), system.getClassName()));

		// Add containers to the list.

		for (Container container : prototype.getContainers()) {
			modules.add(new ContainerModule(container.getId(), container.getName()));
		}

		return Response.ok(modules.toJson()).build();
	}
}
