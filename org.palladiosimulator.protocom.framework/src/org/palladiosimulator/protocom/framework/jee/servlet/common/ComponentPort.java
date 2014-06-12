package org.palladiosimulator.protocom.framework.jee.servlet.common;

import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleStartException;

public abstract class ComponentPort<T> extends PortServlet<T> {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Starts the port and registers it.
	 * @return true if the port was started successfully, otherwise false
	 * @throws ModuleStartException
	 */
	public abstract void start(String componentId, String assemblyContext) throws ModuleStartException;
}
