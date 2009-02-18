package de.uka.ipd.sdq.featureinstance;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class FeatureModelInstancePlugin extends AbstractUIPlugin {
	//The shared instance.
	private static FeatureModelInstancePlugin plugin;
	
	/**
	 * The constructor.
	 */
	public FeatureModelInstancePlugin() {
		super();
		plugin = this;
	}

	/*/**
	 * Returns the shared instance.
	 
	public static FeatureModelInstancePlugin getDefault() {
		return plugin;
	}*/

	/**
	 * Returns the workspace instance.
	 */
	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}
	
	public static ImageDescriptor getImageDescriptor(String name) {
		String iconPath = "icons/";
		try {
			URL installURL = Platform.getBundle("de.uka.ipd.sdq.featureinstance.editor").getEntry("/");
			URL url = new URL(installURL, iconPath + name);
			return ImageDescriptor.createFromURL(url);
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
}
