package de.uka.ipd.sdq.codegen.runconfig;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

/** @author roman */
public class RunConfigImages {
	
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String CONFIGURATION_TAB 	= "configuration_tab";
	public static final String FILENAMES_TAB  		= "filenames_tab";
	public static final String FEATURE_TAB  		= "feature_tab";
	public static final String MAIN_TAB  			= "main_tab";
	
	/** For the toolbar images */
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(CONFIGURATION_TAB,
				 getImageDescriptor(iconPath + CONFIGURATION_TAB + ".gif")
		);
		
		imageRegistry.put(FILENAMES_TAB,
				 getImageDescriptor(iconPath + FILENAMES_TAB + ".gif")
				);
		
		imageRegistry.put(MAIN_TAB,
				 getImageDescriptor(iconPath + MAIN_TAB + ".gif")
		);
		
		imageRegistry.put(FEATURE_TAB,
				 getImageDescriptor(iconPath + FEATURE_TAB + ".gif")
				);
	}

	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return RunConfigPlugin.imageDescriptorFromPlugin(RunConfigPlugin.PLUGIN_ID, imageFilePath);
	}
}
