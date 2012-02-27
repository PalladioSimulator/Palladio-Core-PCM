package de.uka.ipd.sdq.dsexplore;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;



/**
 * The activator class controls the plug-in life cycle
 */
public class DSEPluginActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.dsexplore";

	// The shared instance
	private static DSEPluginActivator plugin;

	//private SimulationDockService service;
	
	/**
	 * The constructor
	 */
	public DSEPluginActivator() {
		plugin= this;
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		
		super.start(context);
		plugin = this;
		
		PropertyConfigurator.configure(findFile("log4j/log4j.properties"));
		
		//service = new DSESimulationDockService(context);

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static DSEPluginActivator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	public static String findFile(String file)
	{
		String result="";
		try
		{
			
			URL url = FileLocator.find(getDefault().getBundle(), new Path(file), null);
			result= FileLocator.toFileURL(url).getPath().toString();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
	
	/**Logs a message to the Eclipse message log.
	 * @param severity Severity of the message.
	 * @param message The message itself.
	 */
	public static void log(final int severity, final String message) {
		/*Status status = new Status(severity, PLUGIN_ID, message, 
				new Throwable());
		plugin.getLog().log(status);*/
		plugin.getLog().log(new Status(severity, PLUGIN_ID, message));
	}
}
