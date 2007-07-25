package de.uka.ipd.sdq.codegen.runconfig;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

/** @author roman */
public class RunConfigImages {
	
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String CONFIGURATION 	= "configuration";
	public static final String FILE_NAMES  		= "file_names";
	
	/** For the toolbar images */
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
		
		imageRegistry.put(FILE_NAMES,
				 getImageDescriptor(iconPath + FILE_NAMES + ".gif")
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
