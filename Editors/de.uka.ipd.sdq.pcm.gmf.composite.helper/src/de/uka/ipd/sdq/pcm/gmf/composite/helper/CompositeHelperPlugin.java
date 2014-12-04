package de.uka.ipd.sdq.pcm.gmf.composite.helper;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class CompositeHelperPlugin extends AbstractUIPlugin {

    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.pcm.gmf.composite.helper";

    /**
     * The shared instance.
     */
    private static CompositeHelperPlugin plugin;

    /**
     * Returns the shared instance.
     * 
     * @return the plugin instance
     */
    public static CompositeHelperPlugin getInstance() {
        return plugin;
    }

    /**
     * The constructor.
     */
    public CompositeHelperPlugin() {
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     * @param context
     *            a BundleContext
     * @throws Exception
     *             an Exception
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     * @param context
     *            a BundleContext
     * @throws Exception
     *             an Exception
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static CompositeHelperPlugin getDefault() {
        return plugin;
    }

}
