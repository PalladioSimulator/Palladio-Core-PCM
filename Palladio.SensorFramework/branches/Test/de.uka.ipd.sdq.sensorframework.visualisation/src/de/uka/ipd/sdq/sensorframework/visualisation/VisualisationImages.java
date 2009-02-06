package de.uka.ipd.sdq.sensorframework.visualisation;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;


public class VisualisationImages {

	public static final String RUN = "lrun_obj";
	public static final String SENSOR = "sensor_obj";
	public static final String EXPERIMENT = "experiment_obj";
	public static final String SENSORS = "sensor_folder";
	public static final String RUNS = "run_folder";
	public static final String TREEROOT = "tree_root";
	public static final String DELETE = "delete_obj";
	public static final String ADD = "add_obj";
	public static final String UP = "up_obj";
	public static final String DOWN = "down_obj";
	
	// Names of images used to represent checkboxes
	public static final String CHECKED_IMAGE 	= "checked";
	public static final String UNCHECKED_IMAGE  = "unchecked";

	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();

	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 

	static {
		String iconPath = "icons/";
		
		imageRegistry.put(RUN,
				 getImageDescriptor(iconPath + RUN + ".gif")
		);
		imageRegistry.put(SENSOR,
				 getImageDescriptor(iconPath + SENSOR + ".gif")
				);
		imageRegistry.put(SENSORS,
				 getImageDescriptor(iconPath + SENSORS + ".gif")
				);
		imageRegistry.put(RUNS,
				 getImageDescriptor(iconPath + RUNS + ".gif")
				);
		imageRegistry.put(EXPERIMENT,
				 getImageDescriptor(iconPath + EXPERIMENT + ".gif")
				);
		imageRegistry.put(TREEROOT,
				 getImageDescriptor(iconPath + TREEROOT + ".gif")
				);
		imageRegistry.put(CHECKED_IMAGE,
				getImageDescriptor(iconPath + CHECKED_IMAGE + ".gif")
			);
		imageRegistry.put(UNCHECKED_IMAGE,
				getImageDescriptor(iconPath + UNCHECKED_IMAGE + ".gif")
			);
		imageRegistry.put(DELETE,
				getImageDescriptor(iconPath + DELETE + ".gif")
			);
		imageRegistry.put(ADD,
				getImageDescriptor(iconPath + ADD + ".gif")
			);
		imageRegistry.put(UP,
				getImageDescriptor(iconPath + UP + ".gif")
			);
		imageRegistry.put(DOWN,
				getImageDescriptor(iconPath + DOWN + ".gif")
			);
	}
	
	/**
	 *@param imageFilePath the relative to the root of the plug-in; the path must be legal
     *@return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return VisualisationPlugin.getImageDescriptor(imageFilePath);
	}
}
