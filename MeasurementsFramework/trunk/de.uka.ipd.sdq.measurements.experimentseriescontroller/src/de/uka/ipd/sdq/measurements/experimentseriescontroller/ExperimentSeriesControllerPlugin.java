package de.uka.ipd.sdq.measurements.experimentseriescontroller;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.measurements.systemadapter.SystemAdapter;

public class ExperimentSeriesControllerPlugin extends Plugin  {

	private static ExperimentSeriesControllerPlugin plugin;

	private SystemAdapter systemController = null;

	public SystemAdapter getSystemController() {
		return systemController;
	}


	public ExperimentSeriesControllerPlugin() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		systemController = de.uka.ipd.sdq.measurements.systemadapter.SystemAdapterPlugin.getDefault().getSystemController();

	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}


	public static ExperimentSeriesControllerPlugin getDefault() {
		return plugin;
	}


}
