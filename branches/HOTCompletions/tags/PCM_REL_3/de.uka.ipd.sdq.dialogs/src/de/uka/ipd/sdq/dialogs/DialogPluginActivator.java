package de.uka.ipd.sdq.dialogs;

import org.eclipse.ui.plugin.AbstractUIPlugin;


public class DialogPluginActivator extends AbstractUIPlugin {

	public final static String PLUGIN_ID = "de.uka.ipd.sdq.dialogs";

	private static DialogPluginActivator plugin;

    public DialogPluginActivator() {
       plugin = this;
    }

    public static DialogPluginActivator getDefault() {
       return plugin;
    }

}
