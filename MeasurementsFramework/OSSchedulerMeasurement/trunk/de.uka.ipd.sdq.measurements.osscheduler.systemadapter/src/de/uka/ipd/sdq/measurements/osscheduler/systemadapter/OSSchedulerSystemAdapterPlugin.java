package de.uka.ipd.sdq.measurements.osscheduler.systemadapter;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

public class OSSchedulerSystemAdapterPlugin extends Plugin {
	
	private static OSSchedulerSystemAdapterPlugin plugin;
	
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.measurements.osscheduler.systemadapter";

	public OSSchedulerSystemAdapterPlugin() {
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		storeDefaultPreferences();

	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}


	public static OSSchedulerSystemAdapterPlugin getDefault() {
		return plugin;
	}
	
	private void storeDefaultPreferences() {
		IEclipsePreferences preferences = new DefaultScope().getNode(PLUGIN_ID);
		preferences.put(Constants.PreferenceKeySystemAdapterPort, "2100");
		preferences.put(Constants.PreferenceKeySystemAdapterIp, "127.0.0.1");
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
