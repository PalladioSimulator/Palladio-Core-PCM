package org.palladiosimulator.protocom.framework.java.ee.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.palladiosimulator.protocom.framework.java.ee.registry.Registry;

@WebServlet("")
public abstract class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected abstract void initPrototype();

	public Main() {
		super();
		initPrototype();

		Registry.setLocation("http://localhost:8080/DevPrototype");
		//Registry.setLocation("http://localhost:8080/org.palladiosimulator.temporary");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		//response.getOutputStream().println("Hallo");

		RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
		dispatcher.forward(request, response);
	}
}
