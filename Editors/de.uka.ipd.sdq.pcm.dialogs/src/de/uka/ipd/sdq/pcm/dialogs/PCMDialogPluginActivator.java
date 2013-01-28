package de.uka.ipd.sdq.pcm.dialogs;

import org.eclipse.ui.plugin.AbstractUIPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class PCMDialogPluginActivator.
 */
public class PCMDialogPluginActivator extends AbstractUIPlugin {

    /** The Constant PLUGIN_ID. */
    public final static String PLUGIN_ID = "de.uka.ipd.sdq.pcm.dialogs";

    /** The plugin. */
    private static PCMDialogPluginActivator plugin;

    /**
     * Instantiates a new pCM dialog plugin activator.
     */
    public PCMDialogPluginActivator() {
        plugin = this;
    }

    /**
     * Gets the default.
     *
     * @return the default
     */
    public static PCMDialogPluginActivator getDefault() {
        return plugin;
    }

}
