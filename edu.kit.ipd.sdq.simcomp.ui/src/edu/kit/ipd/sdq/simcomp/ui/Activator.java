package edu.kit.ipd.sdq.simcomp.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "edu.kit.ipd.sdq.simcomp.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private SimulationComponentUi uiComponent;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("UI bundle started");

		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public void bindSimCompUiComponent(SimulationComponentUi uiComponent) {
		System.out.println("UI Component bound to activator");

		this.uiComponent = uiComponent;
	}

	public void unbindSimCompUiComponent() {
		this.uiComponent = null;
	}

	public SimulationComponentUi getSimCompUiComponent() {
		return uiComponent;
	}

}
