/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerImages;

/**
 * @author admin
 * 
 */
public class ResourceManagerTab {

	public static String GENERATE_PLUGIN_ID = "de.uka.ipd.sdq.codegen.simucominstance";

	/** Models file name input tab */
	public static String REPOSITORY_FILE = "repositoryFile";
	public static String SYSTEM_FILE = "systemFile";
	public static String ALLOCATION_FILE = "allocationFile";
	public static String USAGE_FILE = "usageFile";

	/** Configuration tab*/
	public static String OUTPUT_PATH = "outpath";
	public static String DELETE_PLUGIN = "clear";
	

	/** TODO */
	private static String GENERATE_PLUGIN_PATH;

	public static Image getConfigurationImage() {
		return SimuControllerImages.imageRegistry
				.get(SimuControllerImages.CONFIGURATION);
	}

	public static Image getModelsListImage() {
		return SimuControllerImages.imageRegistry
				.get(SimuControllerImages.MODELS_LIST);
	}
	
	public static Image getSimuComConfImage() {
		return SimuControllerImages.imageRegistry
				.get(SimuControllerImages.SIMUCOM_CONF);
	}

	/**
	 * @return the GENERATE_PLUGIN_PATH
	 */
	public static String getGeneretePluginPath() {
		return GENERATE_PLUGIN_PATH;
	}

	/**
	 * @param generate_plugin_path
	 *            the gENERATE_PLUGIN_PATH to set
	 */
	public static void setGeneretePluginPath(String generate_plugin_path) {
		GENERATE_PLUGIN_PATH = generate_plugin_path;
	}
}
