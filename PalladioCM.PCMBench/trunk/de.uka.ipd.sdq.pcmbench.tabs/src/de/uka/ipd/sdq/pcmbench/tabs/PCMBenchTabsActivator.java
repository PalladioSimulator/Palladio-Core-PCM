package de.uka.ipd.sdq.pcmbench.tabs;

import org.eclipse.ui.plugin.AbstractUIPlugin;

public class PCMBenchTabsActivator extends AbstractUIPlugin {
	
	public final static String PLUGIN_ID = "de.uka.ipd.sdq.pcmbench.tabs";
	
	private static PCMBenchTabsActivator plugin;

    public PCMBenchTabsActivator() {
       plugin = this;
    }

    public static PCMBenchTabsActivator getDefault() {
       return plugin;
    }
}
