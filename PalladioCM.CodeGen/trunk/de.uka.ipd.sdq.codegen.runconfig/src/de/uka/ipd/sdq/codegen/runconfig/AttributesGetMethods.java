package de.uka.ipd.sdq.codegen.runconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;

/**
 * The class is abstract and defines the methods, which are responsible for the
 * supply of variable from the LaunchConfiguration-Object.
 * 
 * @author Roman Andrej
 */
public abstract class AttributesGetMethods {

	protected ILaunchConfiguration configuration;

	public AttributesGetMethods(ILaunchConfiguration configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * The method supplies back a list with files, which represent an instance
	 * of the Palladio Component Model.
	 * 
	 * @throws JobFailedException
	 */
	public List<String> getFiles() throws JobFailedException {
		ArrayList<String> files = new ArrayList<String>();
		try {
			files.add ( configuration
					.getAttribute(ConstantsContainer.REPOSITORY_FILE, ""));
			files.add ( configuration
					.getAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, ""));
			files.add ( configuration
					.getAttribute(ConstantsContainer.SYSTEM_FILE, ""));
			files.add ( configuration
					.getAttribute(ConstantsContainer.ALLOCATION_FILE, ""));
			files.add ( configuration
					.getAttribute(ConstantsContainer.USAGE_FILE, ""));
			return files;
		} catch (Exception e) {
			throw new JobFailedException("Unable to read file names from configuration", e);
		}
	}
	
	/**
	 * The method return a HashMap. Their elements are the properties(String)
	 * contain, which oAW Workflow Engine needs for its work.
	 * @param runNo 
	 * 
	 * @throws JobFailedException
	 */
	public Map<String, String> getOAWWorkflowProperties(int runNo) throws JobFailedException{

		Map<String, String> properties = new HashMap<String, String>();

		try {	
			properties.put(ConstantsContainer.AOP_TEMPLATE, defineTemplateMethod());
			properties.put(ConstantsContainer.REPOSITORY_FILE, configuration
					.getAttribute(ConstantsContainer.REPOSITORY_FILE, ""));
			properties.put(ConstantsContainer.MWREPOSITORY_FILE, configuration
					.getAttribute(ConstantsContainer.MWREPOSITORY_FILE, ""));
			properties.put(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, configuration
					.getAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, ""));
			properties.put(ConstantsContainer.SYSTEM_FILE, configuration
					.getAttribute(ConstantsContainer.SYSTEM_FILE, ""));
			properties.put(ConstantsContainer.ALLOCATION_FILE, configuration
					.getAttribute(ConstantsContainer.ALLOCATION_FILE, ""));
			properties.put(ConstantsContainer.USAGE_FILE, configuration
					.getAttribute(ConstantsContainer.USAGE_FILE, ""));
			properties.put(ConstantsContainer.FEATURE_CONFIG, configuration
					.getAttribute(ConstantsContainer.FEATURE_CONFIG, ""));
			
			String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() 
								+ "/" +
								(runNo > 1 ? this.getPluginId()+"."+runNo : this.getPluginId()) 
								+ "/" + "src";
			properties.put(ConstantsContainer.EAROUT_PATH, basePath);
			properties.put(ConstantsContainer.INTERFACESOUT_PATH, basePath);
			properties.put(ConstantsContainer.CLIENTOUT_PATH, basePath);
			properties.put(ConstantsContainer.EJBSOUT_PATH, basePath);
			
			properties.put(ConstantsContainer.VARIABLE_TEXT, configuration.getAttribute(ConstantsContainer.VARIABLE_TEXT, ""));
			properties.put(ConstantsContainer.MINIMUM_TEXT, configuration.getAttribute(ConstantsContainer.MINIMUM_TEXT, ""));
			properties.put(ConstantsContainer.MAXIMUM_TEXT, configuration.getAttribute(ConstantsContainer.MAXIMUM_TEXT, ""));
			properties.put(ConstantsContainer.STEP_WIDTH_TEXT, configuration.getAttribute(ConstantsContainer.STEP_WIDTH_TEXT, ""));
			properties.put(ConstantsContainer.RUN_NO, runNo+"");

			properties.put(ConstantsContainer.SIMULATE_LINKING_RESOURCES, configuration
					.getAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES, true) ? "true" : "false");
		} catch (Exception e) {
			throw new JobFailedException("Setting up properties failed", e);
		}
		return properties;
	}
	
	/**
	 * @param configuration
	 *            the configuration to launch
	 * @exception CoreException
	 *                if launching fails
	 */
	protected abstract boolean isShouldThrowException(
			ILaunchConfiguration configuration) throws CoreException;
	
	/**
	 * The method define a value of AOP_TEMPLATE attribute
	 */
	protected abstract String defineTemplateMethod();

	/**
	 * The method return the value of OUTPATH attribute in the
	 * ILaunchConfiguration-Object
	 */
	public String getPluginId() {
		String outputPath;
	
		try {
			outputPath = configuration.getAttribute(
					ConstantsContainer.PLUGIN_ID, (String)null);
		} catch (CoreException e) {
			outputPath = null;
		}
	
		return outputPath;
	}
}
