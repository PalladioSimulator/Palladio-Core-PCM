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
	public static final String MODELS_LIST  	= "models_list";
	public static final String SIMU_START  		= "nav_start";
	public static final String SIMU_STOP  		= "nav_stop";
	public static final String SIMU_GENERATE  	= "new_plugin";
	public static final String SIMU_DELETE  	= "del_plugin";
	public static final String SIMUCOM_CONF  	= "simucom_conf";
	
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
		
		imageRegistry.put(MODELS_LIST,
				 getImageDescriptor(iconPath + MODELS_LIST + ".gif")
				);
		imageRegistry.put(SIMU_START,
				 getImageDescriptor(iconPath + SIMU_START + ".gif")
				);
		imageRegistry.put(SIMU_STOP,
				 getImageDescriptor(iconPath + SIMU_STOP + ".gif")
				);
		imageRegistry.put(SIMU_GENERATE,
				 getImageDescriptor(iconPath + SIMU_GENERATE + ".gif")
				);
		imageRegistry.put(SIMU_DELETE,
				 getImageDescriptor(iconPath + SIMU_DELETE + ".gif")
				);
		imageRegistry.put(SIMUCOM_CONF,
				 getImageDescriptor(iconPath + SIMUCOM_CONF + ".gif")
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
