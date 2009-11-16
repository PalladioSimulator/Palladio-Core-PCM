package de.uka.ipd.sdq.measurements.experimentseriescontroller;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.measurements.systemcontroller.SystemController;

public class Activator extends Plugin  {

	private static Activator plugin;

	private SystemController systemController = null;

	public SystemController getSystemController() {
		return systemController;
	}


	public Activator() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		systemController = de.uka.ipd.sdq.measurements.systemcontroller.Activator.getDefault().getSystemController();

	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}


	public static Activator getDefault() {
		return plugin;
	}


}
