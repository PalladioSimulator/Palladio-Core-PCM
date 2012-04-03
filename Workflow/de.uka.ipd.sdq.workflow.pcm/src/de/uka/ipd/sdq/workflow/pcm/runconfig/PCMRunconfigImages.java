package de.uka.ipd.sdq.workflow.pcm.runconfig;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.workflow.pcm.PCMWorkflowPlugin;

/**
 * The class is used for the administration of the images stored in the Plug-Ins 
 * using the workflow engine.
 * This helper class manages an image registry in the background. 
 * To use this utility class a plugin should provide the image file and call the 
 * static method getTabImage() with it's plugin id and it's relative path 
 * to the image (e.g., /icons/filenames_tab.gif).
 * 
 * @author Roman Andrej
 * @author Benjamin Klatt
 */
public class PCMRunconfigImages {
	
	/** For the toolbar images */
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Request an image object for a plugin and image file.
	 * 
	 * This method looks up the requested file in the image registry. 
	 * If it is already available, it will be returned directly.
	 * If not, it will be registered first and returned afterwards.
	 * 
	 * @param pluginID The id of the plugin containing the image file.
	 * @param imageFilePath The relative path of the image within the plugin.
	 * @return The Image file if available.
	 */
	public static Image getTabImage(String pluginID, String imageFilePath){
		String key = pluginID+imageFilePath;
		if(imageRegistry.get(key) == null){
			imageRegistry.put(
					key,
					PCMWorkflowPlugin.imageDescriptorFromPlugin(pluginID, imageFilePath));
		}
		return imageRegistry.get(key);
	}
}

