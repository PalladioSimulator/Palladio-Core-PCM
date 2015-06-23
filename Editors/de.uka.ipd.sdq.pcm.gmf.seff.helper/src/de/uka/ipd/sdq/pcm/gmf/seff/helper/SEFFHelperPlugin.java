package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class SEFFHelperPlugin extends AbstractUIPlugin {

    /** The plug-in ID. */
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.pcm.gmf.seff.helper";

    /** The shared instance. */
    private static SEFFHelperPlugin plugin;

    /**
     * The constructor.
     */
    public SEFFHelperPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    /**
     * Start.
     * 
     * @param context
     *            the context
     * @throws Exception
     *             the exception
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(final BundleContext context) throws Exception {
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
     * @param context
     *            the context
     * @throws Exception
     *             the exception
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static SEFFHelperPlugin getDefault() {
        return plugin;
    }

}
