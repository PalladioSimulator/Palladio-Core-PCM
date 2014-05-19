package edu.kit.ipd.sdq.eventsim.workload;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import edu.kit.ipd.sdq.simcomp.workload.component.IWorkload;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private static Activator plugin;

	private IWorkload workloadComponent;

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
		Activator.context = bundleContext;
		Activator.plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		Activator.plugin = null;
	}

	public void bindWorkloadComponent(IWorkload simulationMiddleware) {
		System.out.println("Workload bound to activator");

		this.workloadComponent = simulationMiddleware;
	}

	public void unbindWorkloadComponent() {
		this.workloadComponent = null;
	}

	public IWorkload getWorkloadComponent() {
		return workloadComponent;
	}

}
