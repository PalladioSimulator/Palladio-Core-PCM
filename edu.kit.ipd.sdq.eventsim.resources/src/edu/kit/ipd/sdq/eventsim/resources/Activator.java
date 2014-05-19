package edu.kit.ipd.sdq.eventsim.resources;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import edu.kit.ipd.sdq.simcomp.resource.active.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.resource.passive.component.IPassiveResource;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private static Activator plugin;

	private IActiveResource activeResourceComponent;
	private IPassiveResource passiveResourceComponent;

	static BundleContext getContext() {
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

	public void bindActiveResourceComponent(IActiveResource activeResourceComponent) {
		System.out.println("ActiveResource bound to activator");
		this.activeResourceComponent = activeResourceComponent;
	}

	public void unbindActiveResourceComponent() {
		this.activeResourceComponent = null;
	}

	public IActiveResource getActiveResourceComponent() {
		return activeResourceComponent;
	}

	public void bindPassiveResourceComponent(IPassiveResource passiveResourceComponent) {
		System.out.println("PassiveResource bound to activator");
		this.passiveResourceComponent = passiveResourceComponent;
	}

	public void unbindPassiveResourceComponent() {
		this.passiveResourceComponent = null;
	}

	public IPassiveResource getPassiveResourceComponent() {
		return passiveResourceComponent;
	}

}
