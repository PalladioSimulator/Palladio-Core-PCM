package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class OSSchedulerSystemAdapterPlugin extends Plugin {
	
	private static OSSchedulerSystemAdapterPlugin plugin;

	public OSSchedulerSystemAdapterPlugin() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}


	public static OSSchedulerSystemAdapterPlugin getDefault() {
		return plugin;
	}

}
