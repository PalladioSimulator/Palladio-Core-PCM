package de.uka.ipd.sdq.measurements.osscheduler.experimentcontroller;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class OSSchedulerExperimentControllerPlugin extends Plugin {
	
	private static OSSchedulerExperimentControllerPlugin plugin;
	
	private OSSchedulerExperimentController osSchedulerExperimentController = null;

	public OSSchedulerExperimentController getOsSchedulerExperimentController() {
		return osSchedulerExperimentController;
	}


	public OSSchedulerExperimentControllerPlugin() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		System.out.println("YES!");
		osSchedulerExperimentController = new OSSchedulerExperimentController();

	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}


	public static OSSchedulerExperimentControllerPlugin getDefault() {
		return plugin;
	}

}
