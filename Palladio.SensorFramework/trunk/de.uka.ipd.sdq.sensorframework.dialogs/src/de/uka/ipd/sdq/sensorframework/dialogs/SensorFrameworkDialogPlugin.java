package de.uka.ipd.sdq.sensorframework.dialogs;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class SensorFrameworkDialogPlugin extends AbstractUIPlugin {

	private static SensorFrameworkDialogPlugin plugin = null;

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.sensorframework.dialogs";
	
	public SensorFrameworkDialogPlugin() {
		// TODO Auto-generated constructor stub
	}
	
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

	public static void log(int severity, String message) {
		plugin.getLog().log(new Status(severity,PLUGIN_ID,message));
	}
	
}
