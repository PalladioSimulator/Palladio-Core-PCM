package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import de.uka.ipd.sdq.pcmbench.tabs.PCMBenchTabsActivator;

/**
 * @author admin
 *
 */
public class TabResources {

	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";
	
	public static String PLUGIN_ID = PCMBenchTabsActivator.PLUGIN_ID;

	//	 Names of images used to represent actions in ToolBar
	public static final String ADD_SIGN 	= "add_sign";
	public static final String DELETE_SIGN  = "delete_sign";
	public static final String ADD_PARAM 	= "add_param";
	public static final String DELETE_PARAM = "delete_param";
	
	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(ADD_SIGN,
				 getImageDescriptor(iconPath + ADD_SIGN + ".gif")
		);
		
		imageRegistry.put(DELETE_SIGN,
				 getImageDescriptor(iconPath + DELETE_SIGN + ".gif")
				);
		
		imageRegistry.put(ADD_PARAM,
				 getImageDescriptor(iconPath + ADD_PARAM + ".gif")
		);
		
		imageRegistry.put(DELETE_PARAM,
				 getImageDescriptor(iconPath + DELETE_PARAM + ".gif")
				);
	}
	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return PCMBenchTabsActivator.imageDescriptorFromPlugin(TabResources.PLUGIN_ID, imageFilePath);
	}

}
