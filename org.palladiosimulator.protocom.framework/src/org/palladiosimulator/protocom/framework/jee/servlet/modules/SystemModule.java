package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;

public class SystemModule extends Module {

	public SystemModule(String id, String name) {
		super(id, name, true);
	}

	@Override
	public Response startModule(String location) {
		return new Response(Response.FAILED);
	}
}
