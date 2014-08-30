package de.uka.ipd.sdq.pcm.gmf.repository.custom;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends Plugin {

    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.pcm.gmf.repository.custom";

    /**
     * The shared instance.
     */
    private static Activator plugin;

    /**
     * The constructor.
     */
    public Activator() {
    }

    /**
     * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     * 
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
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     * 
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
    public static Activator getDefault() {
        return plugin;
    }

}
