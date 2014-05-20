package edu.kit.ipd.sdq.simcomp.ui;

import org.osgi.service.component.ComponentContext;

import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

public class SimulationComponentUi {

	private ISimulationMiddleware middleware;
	private Activator simCompUiActivator;

	/**
	 * Binds a simulation middleware instance to the UI component.
	 * 
	 * @param middleware
	 */
	public void bindSimulationMiddleware(ISimulationMiddleware middleware) {
		this.middleware = middleware;
	}

	/**
	 * Unbinds a simulation middleware instance to the UI component.
	 * 
	 * @param middleware
	 */
	public void unbindSimulationMiddleware(ISimulationMiddleware middleware) {
		if (this.middleware.equals(middleware)) {
			this.middleware = null;
		}
	}

	public ISimulationMiddleware getSimulationMiddleware() {
		return this.middleware;
	}

	/**
	 * Declarative service lifecycle method called when the workload simulation
	 * component is activated.
	 * 
	 * @param context
	 */
	public void activate(ComponentContext context) {
		this.simCompUiActivator = Activator.getDefault();
		this.simCompUiActivator.bindSimCompUiComponent(this);
	}

	/**
	 * Declarative service lifecycle method called when the workload simulation
	 * component is deactivated.
	 * 
	 * @param context
	 */
	public void deactivate(ComponentContext context) {
		this.simCompUiActivator.unbindSimCompUiComponent();
		this.simCompUiActivator = null;
	}
}
