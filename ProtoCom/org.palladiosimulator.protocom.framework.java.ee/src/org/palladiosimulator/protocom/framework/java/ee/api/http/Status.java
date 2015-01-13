package org.palladiosimulator.protocom.framework.java.ee.api.http;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;

@Path("/status")
public class Status {
	@Context
	private ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getStatus() {
		String value = (String) context.getAttribute("status");

		if (value == null) {
			value = "initial";
			context.setAttribute("status", value);
		}

		HashMap<String, Object> status = new HashMap<String, Object>();
		status.put("status", value);

		return JsonHelper.toJson(status);
	}
}
