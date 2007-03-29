/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

/**
 * @author admin
 *
 */
public class SimuControllerImages {
	
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String CONFIGURATION 	= "configuration";
	public static final String MODELSLIST  = "models_list";
	
	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(CONFIGURATION,
				 getImageDescriptor(iconPath + CONFIGURATION + ".gif")
		);
		
		imageRegistry.put(MODELSLIST,
				 getImageDescriptor(iconPath + MODELSLIST + ".gif")
				);
	}

	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return SimuControllerPlugin.imageDescriptorFromPlugin(SimuControllerPlugin.PLUGIN_ID, imageFilePath);
	}
}
