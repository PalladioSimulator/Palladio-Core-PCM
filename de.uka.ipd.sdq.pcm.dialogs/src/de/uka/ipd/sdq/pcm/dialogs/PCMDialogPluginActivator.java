package de.uka.ipd.sdq.pcm.dialogs;

import org.eclipse.ui.plugin.AbstractUIPlugin;

public class PCMDialogPluginActivator extends AbstractUIPlugin {

    public final static String PLUGIN_ID = "de.uka.ipd.sdq.pcm.dialogs";

    private static PCMDialogPluginActivator plugin;

    public PCMDialogPluginActivator() {
        plugin = this;
    }

    public static PCMDialogPluginActivator getDefault() {
        return plugin;
    }

}
