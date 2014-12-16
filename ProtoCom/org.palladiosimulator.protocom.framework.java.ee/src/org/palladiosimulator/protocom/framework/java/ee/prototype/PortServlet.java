package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.java.ee.experiment.ExperimentVisitor;
import org.palladiosimulator.protocom.framework.java.ee.modules.ModuleStartException;
import org.palladiosimulator.protocom.framework.java.ee.protocol.RemoteCall;
import org.palladiosimulator.protocom.framework.java.ee.protocol.Response;
import org.palladiosimulator.protocom.framework.java.ee.protocol.StringResponse;

/**
 * The PortServlet class is the common base class for ports.
 * @param <T> the type of the component of the port
 * @author Christian Klaussner
 */
public abstract class PortServlet<T> extends HttpServlet implements IPort<T> {
	private static final long serialVersionUID = 1L;

	protected String location;
	protected T component;

	@Inject
	private ExperimentVisitor experimentVisitor;

	private final List<ICallVisitor> visitors;

	public PortServlet() {
		visitors = new LinkedList<ICallVisitor>();
	}

	/**
	 * Starts the port and registers it.
	 * @param componentId identifier of the started component
	 * @param assemblyContext assembly context of the started component
	 * @throws ModuleStartException when the module could not be started
	 */
	public void start(String componentId, String assemblyContext) throws ModuleStartException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse httpResponse)
			throws ServletException, IOException {

		if (request.getParameter("action").equals("start")) {
			if (location == null) {
				location = request.getParameter("location");
			}

			StringResponse response = new StringResponse();

			try {
				//String componentId = request.getParameter("componentId");
				String assemblyContext = request.getParameter("assemblyContext");

				String innerPortId = request.getParameter("componentId");

				addVisitor(experimentVisitor);
				start(innerPortId, assemblyContext);
				response.setError(Response.OK);
			} catch (ModuleStartException e) {
				response.setError(Response.FAILED);
			}

			httpResponse.setContentType("application/json");
			httpResponse.getOutputStream().print(response.toJson());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringWriter call = new StringWriter();
		IOUtils.copy(request.getInputStream(), call);

		RemoteCall remoteCall = RemoteCall.fromJson(call.toString());
		remoteCall.dispatch(this);
	}

	/**
	 *
	 * @param visitor
	 */
	protected void addVisitor(ICallVisitor visitor) {
		visitors.add(visitor);
	}

	/**
	 *
	 * @param callId
	 */
	protected void preCall(String callId) {
		for (ICallVisitor visitor : visitors) {
			visitor.preCallVisit(callId);
		}
	}

	/**
	 *
	 * @param callId
	 */
	protected void postCall(String callId) {
		for (ICallVisitor visitor : visitors) {
			visitor.postCallVisit(callId);
		}
	}
}
