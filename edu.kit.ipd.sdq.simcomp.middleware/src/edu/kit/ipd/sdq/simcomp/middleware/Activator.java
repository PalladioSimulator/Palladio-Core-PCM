package edu.kit.ipd.sdq.simcomp.middleware;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

public class Activator implements BundleActivator {

	private static Activator plugin;
	private static BundleContext context;

	private ISimulationMiddleware simulationMiddleware;

	public static BundleContext getContext() {
		return context;
	}

	/**
	 * Gives static access to the bundle activator.
	 * 
	 * @return The shared activator instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("SimulationMiddleware bundle start");

		Activator.context = bundleContext;
		Activator.plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("SimulationMiddleware bundle stop");
		Activator.context = null;
	}

	public void bindSimulationMiddleware(ISimulationMiddleware simulationMiddleware) {
		System.out.println("SimulationMiddleware bound");
		this.simulationMiddleware = simulationMiddleware;
	}

	public void unbindSimulationMiddleware() {
		this.simulationMiddleware = null;
	}

	public ISimulationMiddleware getSimulationMiddleware() {
		return simulationMiddleware;
	}

}
