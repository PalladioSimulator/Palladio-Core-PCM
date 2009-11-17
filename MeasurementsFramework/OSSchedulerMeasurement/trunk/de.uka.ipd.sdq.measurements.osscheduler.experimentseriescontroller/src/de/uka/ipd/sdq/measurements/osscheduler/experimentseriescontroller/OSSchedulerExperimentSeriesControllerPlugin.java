package de.uka.ipd.sdq.measurements.osscheduler.experimentseriescontroller;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class OSSchedulerExperimentSeriesControllerPlugin extends Plugin  {

	private static OSSchedulerExperimentSeriesControllerPlugin plugin;

	public OSSchedulerExperimentSeriesControllerPlugin() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		de.uka.ipd.sdq.measurements.experimentseriescontroller.ExperimentSeriesControllerPlugin.getDefault();

	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}


	public static OSSchedulerExperimentSeriesControllerPlugin getDefault() {
		return plugin;
	}


}
