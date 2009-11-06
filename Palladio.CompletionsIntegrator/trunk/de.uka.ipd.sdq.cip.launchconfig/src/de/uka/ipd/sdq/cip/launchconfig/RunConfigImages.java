package de.uka.ipd.sdq.cip.launchconfig;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * The class is used for the administration the images stored in the Plug-In.
 * 
 * @author Roman Andrej
 */
public class RunConfigImages {
	
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String COMPLETION_TAB 		= "completion_tab";
	
	/** For the toolbar images */
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 
	static {
		String iconPath = "icons/";
		
		imageRegistry.put(COMPLETION_TAB,
				 getImageDescriptor(iconPath + COMPLETION_TAB + ".gif")
		);
	}

	
	/**
	 * @param imageFilePath
	 *            the relative to the root of the plug-in; the path must be
	 *            legal
	 * @return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imageFilePath);
	}

	public static Image getCompletionTabImage() {
		return imageRegistry.get(COMPLETION_TAB);
	}
	
}
