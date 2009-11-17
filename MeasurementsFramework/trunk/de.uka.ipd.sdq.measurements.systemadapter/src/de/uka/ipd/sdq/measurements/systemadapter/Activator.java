package de.uka.ipd.sdq.measurements.systemadapter;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

public class Activator extends Plugin {

	private static Activator plugin;
	private SystemAdapter systemController;
	
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.measurements.systemcontroller";
	
	
	public static final String RMI_PORT_PROPERTY = "rmiPort";
	public static final String RMI_IP_PROPERTY = "rmiIp";

	
	public Activator() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		storeDefaultPreferences();
		systemController = new SystemAdapter();
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		if (systemController!=null) {
			systemController.cleanup();
			systemController = null;
		}
	}
	
	public static Activator getDefault() {
		return plugin;
	}
	
	public SystemAdapter getSystemController() {
		return systemController;
	}
	
	private void storeDefaultPreferences() {
		IEclipsePreferences preferences = new DefaultScope().getNode(PLUGIN_ID);
		preferences.put(RMI_PORT_PROPERTY, "2101");
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			
		}
	}
	
	public String getPreference(String key) {
		IEclipsePreferences preferences = new InstanceScope().getNode(PLUGIN_ID);
		IEclipsePreferences defaultPreferences = new DefaultScope().getNode(PLUGIN_ID);
		return preferences.get(key, defaultPreferences.get(key, null));
	}
	
	public int getIntPreference(String key) {
		IEclipsePreferences preferences = new InstanceScope().getNode(PLUGIN_ID);
		IEclipsePreferences defaultPreferences = new DefaultScope().getNode(PLUGIN_ID);
		return preferences.getInt(key, defaultPreferences.getInt(key, 0));
	}
	
	
}
