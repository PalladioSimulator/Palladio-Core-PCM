package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**Activator class for the R plug-in.
 * The activator class controls the plug-in life cycle.
 */
public class RVisualisationPlugin extends AbstractUIPlugin {

	/** The plug-in identifier of the R visualization plug-in. */
	public static final String PLUGIN_ID = 
		"de.uka.ipd.sdq.sensorframework.rvisualisation";

	/** The shared plug-in instance. */
	private static RVisualisationPlugin plugin;
	
	/**Default constructor.
	 */
	public RVisualisationPlugin() {
		// Nothing to do here.
	}

	/** {@inheritDoc}
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/** {@inheritDoc}
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**Returns the shared plug-in instance.
	 * @return the shared instance
	 */
	public static RVisualisationPlugin getDefault() {
		return plugin;
	}

	/**Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(final String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	/**Logs a message to the Eclipse message log.
	 * @param severity Severity of the message.
	 * @param message The message itself.
	 */
	public static void log(final int severity, final String message) {
		Status status = new Status(severity, PLUGIN_ID, message, 
				new Throwable());
		plugin.getLog().log(status);
		plugin.getLog().log(new Status(severity, PLUGIN_ID, message));
	}
}
