/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.codegen.simucontroller.Activator;

/**
 * @author admin
 *
 */
public class ResourceManagerTab {
	
	public static String GENERATE_PLUGIN_ID = "de.uka.ipd.sdq.codegen.simucominstance";
	
	/**
	 * TODO
	 * The default value for the 'width' attribute.
	 */
	public static String REPOSITORY_FILE 	= "repositoryFile";
	public static String SYSTEM_FILE 		= "systemFile";
	public static String ALLOCATION_FILE 	= "allocationFile";
	public static String USAGE_FILE 		= "usageFile";
	
	public static String OUTPUT_PATH 		= "outpath";
	
	/**
	 * TODO
	 */
	private static String GENERATE_PLUGIN_PATH;

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
		return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imageFilePath);
	}

	public static Image getConfigurationImage(){
		return imageRegistry.get(CONFIGURATION);
	}

	public static Image getModelsListImage(){
		return imageRegistry.get(MODELSLIST);
	}

	/**
	 * @return the GENERATE_PLUGIN_PATH
	 */
	public static String getGeneretePluginPath() {
		return GENERATE_PLUGIN_PATH;
	}

	/**
	 * @param generate_plugin_path the gENERATE_PLUGIN_PATH to set
	 */
	public static void setGeneretePluginPath(String generate_plugin_path) {
		GENERATE_PLUGIN_PATH = generate_plugin_path;
	}
}
