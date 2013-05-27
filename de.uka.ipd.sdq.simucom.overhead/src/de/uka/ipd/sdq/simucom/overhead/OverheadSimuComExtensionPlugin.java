package de.uka.ipd.sdq.simucom.overhead;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;

public class OverheadSimuComExtensionPlugin extends Plugin {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.simucom.overhead";
	
	private static OverheadSimuComExtensionPlugin plugin;
	
	/** For the toolbar images */
	private ImageRegistry imageRegistry = null;
	
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String OVERHEAD_TAB = "overhead_tab";
	
	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		String iconPath = "icons/";
		imageRegistry = new ImageRegistry(PlatformUI.getWorkbench().getDisplay());
		imageRegistry.put(OVERHEAD_TAB, getImageDescriptor(iconPath + "overhead_icon.gif"));

	}
	
	/**
	 * @param imageFilePath
	 *            the relative to the root of the plug-in; the path must be
	 *            legal
	 * @return an image descriptor, or null if no image could be found
	 */
	private ImageDescriptor getImageDescriptor(String imageFilePath) {
		return RunConfigPlugin.imageDescriptorFromPlugin(OverheadSimuComExtensionPlugin.PLUGIN_ID, imageFilePath);
	}
	
	public Image getOverheadTabImage() {
		return imageRegistry.get(OVERHEAD_TAB);
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		imageRegistry.dispose();
		imageRegistry = null;
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static OverheadSimuComExtensionPlugin getDefault() {
		return plugin;
	}

}
