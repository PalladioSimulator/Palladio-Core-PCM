package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class UsageHelperPlugin extends AbstractUIPlugin {

    // The plug-in ID
    /** The Constant PLUGIN_ID. */
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.pcm.gmf.usage.helper";

    // The shared instance
    /** The plugin. */
    private static UsageHelperPlugin plugin;

    /**
     * The constructor.
     */
    public UsageHelperPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    /**
     * Start.
     *
     * @param context the context
     * @throws Exception the exception
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    /**
     * Stop.
     *
     * @param context the context
     * @throws Exception the exception
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     *
     * @return the shared instance
     */
    public static UsageHelperPlugin getDefault() {
        return plugin;
    }

}
