package de.uka.ipd.sdq.sensorframework.dialogs;

import org.eclipse.ui.plugin.AbstractUIPlugin;


public class SensorframeworkDialogsPluginActivator extends AbstractUIPlugin {

	public final static String PLUGIN_ID = "de.uka.ipd.sdq.sensorframework.dialogs";

	private static SensorframeworkDialogsPluginActivator plugin;

    public SensorframeworkDialogsPluginActivator() {
       plugin = this;
    }

    public static SensorframeworkDialogsPluginActivator getDefault() {
       return plugin;
    }

}
