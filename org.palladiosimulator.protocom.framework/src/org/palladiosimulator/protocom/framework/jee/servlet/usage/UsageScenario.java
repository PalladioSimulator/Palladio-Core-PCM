package org.palladiosimulator.protocom.framework.jee.servlet.usage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleStartException;

public abstract class UsageScenario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected abstract void start() throws ModuleStartException;
	protected abstract void run();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		
		StringResponse response =  new StringResponse();
		
		if (request.getParameter("action").equals("start")) {
			try {
				start();
				response.setError(Response.OK);
			} catch (ModuleStartException e) {
				response.setError(Response.FAILED);
			}
		}
		else if (request.getParameter("action").equals("run")) {
			run();
			response.setError(Response.OK);
		}
		else response.setError(Response.INVALID);
		
		httpResponse.setContentType("application/json");
		httpResponse.getOutputStream().print(response.toJson());
	}
}
