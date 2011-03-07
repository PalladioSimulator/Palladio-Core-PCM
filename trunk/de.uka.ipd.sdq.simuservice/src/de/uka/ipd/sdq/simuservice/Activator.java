package de.uka.ipd.sdq.simuservice;

import java.io.File;
import java.io.PrintWriter;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.simuservice";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// create the default configuration file
		IPath stateLocation = Activator.getDefault().getStateLocation();
		File stateFile = stateLocation.append("simuservice.config").toFile();
		if(!stateFile.exists()){
			PrintWriter writer = new PrintWriter(stateFile);
			writer.println("PORT=8082");
			writer.close();
		}
		
		
		//Create and start a new Web Server 
		Thread webserviceServer = new SimulationProvidingWebServer();
		webserviceServer.start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static Activator getDefault() {
		return plugin;
	}

}
