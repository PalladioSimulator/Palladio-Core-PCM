package de.uka.ipd.sdq.measurements.osscheduler.ui;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class OSSchedulerUIPlugin extends Plugin {

	private static OSSchedulerUIPlugin plugin;
	
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.measurements.osscheduler.ui";
	
	public OSSchedulerUIPlugin() {
		
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


	public static OSSchedulerUIPlugin getDefault() {
		return plugin;
	}
}
