package org.palladiosimulator.protocom.framework.java.ee.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.prototype.PrototypeBridge;
import org.palladiosimulator.protocom.framework.java.ee.registry.Registry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author Christian Klaussner
 */
@WebServlet("")
public abstract class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger.getRootLogger();

	private boolean firstRequest = true;

	/**
	 *
	 */
	protected abstract void initPrototype(PrototypeBridge bridge);

	/**
	 *
	 */
	public Main() {
		super();

		// Initialize logging.

		LOGGER.removeAllAppenders();
		LOGGER.addAppender(new WebAppender());

		LOGGER.setLevel(Level.INFO);

		/*
		 * Initialization of Guice is usually done in a ServletContextListener.
		 * However, the EcmService class of the SAP HANA Cloud Document Service
		 * is loaded after the Guice initialization (via web.xml), which makes it
		 * impossible for injected IStorage instances to connect to the service.
		 */
		Injector injector = Guice.createInjector(new ProtoComModule());

		// Get an instance of the bridge and initialize the prototype.

		PrototypeBridge bridge = injector.getInstance(PrototypeBridge.class);
		initPrototype(bridge);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		if (firstRequest) {
			Registry.getInstance().setLocation(request.getRequestURL().toString());
			firstRequest = false;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Main.jsp");
		dispatcher.forward(request, response);
	}
}
