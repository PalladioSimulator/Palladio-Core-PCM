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
import org.palladiosimulator.protocom.framework.java.ee.registry.Registry;

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
	protected abstract void initPrototype();

	public Main() {
		super();

		LOGGER.removeAllAppenders();
		LOGGER.addAppender(new WebAppender());

		LOGGER.setLevel(Level.INFO);

		initPrototype();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		if (firstRequest) {
			Registry.getInstance().setLocation(request.getRequestURL().toString());
			firstRequest = false;
		}

		//response.getOutputStream().println("Hallo");

		RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
		dispatcher.forward(request, response);
	}
}
