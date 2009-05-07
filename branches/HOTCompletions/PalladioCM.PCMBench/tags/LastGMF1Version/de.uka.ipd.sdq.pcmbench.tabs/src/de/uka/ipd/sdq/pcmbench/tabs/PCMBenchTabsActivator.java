/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class PCMBenchTabsActivator extends AbstractUIPlugin {
	
	public final static String PLUGIN_ID = "de.uka.ipd.sdq.pcmbench.tabs";
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}
	
	private static PCMBenchTabsActivator plugin;

    public PCMBenchTabsActivator() {
       plugin = this;
    }

    public static PCMBenchTabsActivator getDefault() {
       return plugin;
    }
}
