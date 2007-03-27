package de.uka.ipd.sdq.codegen.simudatavisualization;

import java.util.ArrayList;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ReportCongiguration;

/**
 * The activator class controls the plug-in life cycle
 */
public class SimuPlugin extends AbstractUIPlugin {
	
	private ArrayList<ReportCongiguration> configObjects;

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.codegen.simudatavisualization";

	// The shared instance
	private static SimuPlugin plugin;
	
	/**
	 * The constructor
	 */
	public SimuPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		configObjects = new ArrayList<ReportCongiguration>();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SimuPlugin getDefault() {
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

	public ArrayList<ReportCongiguration> getConfigObjects() {
		return configObjects;
	}
}
