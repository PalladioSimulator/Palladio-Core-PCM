package de.uka.ipd.sdq.codegen.runconfig;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RunConfigPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.codegen.runconfig";

	// The shared instance
	private static RunConfigPlugin plugin;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 */
	public static RunConfigPlugin getDefault() {
		return plugin;
	}

	public static void log(int severity, String message){
		plugin.getLog().log(new Status(severity,PLUGIN_ID,message));
	}
	
	/**
	 * The method logs the errors with the tab initialization.
	 * @return 
	 */
	public static void errorLogger(String tabName, String fieldName, String msg) {
		log(IStatus.ERROR, "The field " + fieldName + " in the " + tabName
				+ " Tab cannot be initialized. " + msg);
	}
}
