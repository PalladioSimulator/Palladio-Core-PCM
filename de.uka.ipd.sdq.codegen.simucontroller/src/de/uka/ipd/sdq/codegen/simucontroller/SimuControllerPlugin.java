package de.uka.ipd.sdq.codegen.simucontroller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DocksModel;
import de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart;
import de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewer;

/**
 * The activator class controls the plug-in life cycle
 */
public class SimuControllerPlugin extends AbstractUIPlugin {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SimuControllerPlugin.class);

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.codegen.simucontroller";

	// The shared instance
	private static SimuControllerPlugin plugin;

	private static DocksModel dockModel = null;

	/**
	 * The constructor
	 */
	public SimuControllerPlugin() {
		plugin = this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {

		context.addBundleListener(new BundleListener(){

			public void bundleChanged(BundleEvent event) {
				if (event.getType() == BundleEvent.INSTALLED){

				}
			}
		});
		super.start(context);

		ensurePluginLoaded(context,"org.eclipse.equinox.event");
		ensurePluginLoaded(context,"org.eclipse.equinox.log");
		ensurePluginLoaded(context, "ch.ethz.iks.slp");
		ensurePluginLoaded(context,"ch.ethz.iks.r_osgi.remote");
		ensurePluginLoaded(context,"ch.ethz.iks.r_osgi.service_discovery.slp");

		dockModel = new DocksModel(context);
		
		// FB 2011-06-29: added exception handling. If the SimuControllerPlugin is
		// loaded right at the start of the platform (e.g., the SLA@SOI prediction
		// server does this in order to publish a simulation service), then it may
		// be loaded before the workbench itself, and the SimuDock cannot be
		// displayed.
		try {
			DockStatusViewer.showSimuDockView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ensurePluginLoaded(BundleContext context, String bundleName) {
		for (Bundle b : context.getBundles()) {
			if (b.getSymbolicName().equals(bundleName)) {
				if (b.getState() != Bundle.ACTIVE){
					try {
						b.start();
						while (b.getState() != Bundle.ACTIVE){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								if(logger.isEnabledFor(Level.WARN)) 
									logger.warn("Waiting for initalization was aborted unexpectedly.", e);
							}
						}
					} catch (BundleException e) {
						if(logger.isEnabledFor(Level.ERROR)) 
							logger.error("Error while starting the OSGI bundle occured.", e);
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		//extCache.shutdown();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 */
	public static SimuControllerPlugin getDefault() {
		return plugin;
	}

	public static void log(int severity, String message){
		plugin.getLog().log(new Status(severity,PLUGIN_ID,message));
	}

	public static DocksModel getDockModel() {
		return dockModel;
	}

}
