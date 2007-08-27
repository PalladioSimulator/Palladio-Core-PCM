/**
 * 
 */
package de.uka.ipd.sdq.codegen.runconfig.tabs;

import org.eclipse.core.resources.ResourcesPlugin;


/**
 * This class is used as a constant container.
 * 
 * @author Roman Andrej
 */
public class ConstantsContainer {

	/** Model filenames value */
	public static final String RESOURCETYPEREPOSITORY_FILE = "resourceTypeFile";
	public static final String REPOSITORY_FILE = "repositoryFile";
	public static final String SYSTEM_FILE = "systemFile";
	public static final String ALLOCATION_FILE = "allocationFile";
	public static final String USAGE_FILE = "usageFile";
	
	/** Template method value*/
	public static final String AOP_TEMPLATE  = "aop_templates";
	
	/**
	 * Set the file extensions which the dialog will use to filter the files it
	 * shows to the argument.
	 */
	public static final String[] RESOURCETYPE_EXTENSION = new String[] { "*.resourcetype" };
	public static final String[] REPOSITORY_EXTENSION = new String[] { "*.repository" };
	public static final String[] SYSTEM_EXTENSION = new String[] { "*.system" };
	public static final String[] ALLOCATION_EXTENSION = new String[] { "*.allocation" };
	public static final String[] USAGEMODEL_EXTENSION = new String[] { "*.usagemodel" };

	/** Configuration tab*/
	public static final String OUTPUT_PATH = "outpath";
	public static final String DELETE_PLUGIN = "clear";
	
	/** Feature options tab*/
	public static final String SIMULATE_LINKING_RESOURCES = "respectLinkingResources";
	public static final String COMPONENT_LOOKUP = "componentLookup";

	public static String WORKSPACE_LOCATION = ResourcesPlugin.getWorkspace()
			.getRoot().getLocation().toString()
			+ "/de.uka.ipd.sdq.codegen.simucominstance/src";
}
