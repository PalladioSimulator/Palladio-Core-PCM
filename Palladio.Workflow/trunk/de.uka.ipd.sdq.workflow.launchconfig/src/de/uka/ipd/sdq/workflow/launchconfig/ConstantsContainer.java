package de.uka.ipd.sdq.workflow.launchconfig;

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

	public static final String MWREPOSITORY_FILE = "mwRepositoryFile";
	
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
	public static final String PLUGIN_ID = "outpath";
	public static final String DELETE_PLUGIN = "clear";
	
	public static final String VARIABLE_TEXT = "variable";
	public static final String MINIMUM_TEXT = "minimum";
	public static final String MAXIMUM_TEXT = "maximum";
	public static final String STEP_WIDTH_TEXT = "stepwidth";
	public static final String RUN_NO = "runNo";
	
	/** Output path settings */
	public static final String EAROUT_PATH = "earOutpath";
	public static final String INTERFACESOUT_PATH = "interfacesOutpath";
	public static final String CLIENTOUT_PATH = "clientOutpath";
	public static final String EJBSOUT_PATH = "ejbsOutpath";
	public static final String FEATURE_CONFIG = "featureConfig";
	public static final String FEATURE_FILE = "featureFile";
	public static final String SIMULATE_LINKING_RESOURCES = "simulateLinkingResources";
	
	/** Default values */
	public static String SIMUCOM_DEFAULT_PROJECT_ID = "de.uka.ipd.sdq.codegen.simucominstance";
}
