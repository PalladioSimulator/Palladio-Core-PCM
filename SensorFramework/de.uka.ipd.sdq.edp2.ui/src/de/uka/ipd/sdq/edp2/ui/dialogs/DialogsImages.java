package de.uka.ipd.sdq.edp2.ui.dialogs;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import de.uka.ipd.sdq.edp2.ui.Activator;

/**
 * Compilation of the pictures used in EDP2 dialogs.
 * 
 * @author Sebastian Lehrig
 */
public class DialogsImages {

	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String TREEROOT = "tree_root";

	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();

	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */
	static {
		String iconPath = "icons/";

		imageRegistry.put(TREEROOT,
				 getImageDescriptor(iconPath + TREEROOT + ".gif"));
	}

	/**
	 * @param imageFilePath
	 *            the relative to the root of the plug-in; the path must be
	 *            legal
	 * @return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(
		        Activator.PLUGIN_ID, imageFilePath);
	}

}
