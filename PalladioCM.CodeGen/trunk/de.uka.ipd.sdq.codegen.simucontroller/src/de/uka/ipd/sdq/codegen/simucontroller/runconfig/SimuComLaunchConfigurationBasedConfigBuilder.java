package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimuComLaunchConfigurationBasedConfigBuilder extends
		SimuComConfigurationBuilder {

	private boolean isDebug;
	private Map<String, Object> properties;
	private ILaunchConfiguration configuration;

	@SuppressWarnings("unchecked")
	public SimuComLaunchConfigurationBasedConfigBuilder(
			ILaunchConfiguration configuration, String mode) throws CoreException {
		this.configuration = configuration;
		this.properties = configuration.getAttributes();
		this.isDebug = mode.equals(ILaunchManager.DEBUG_MODE);
	}

	@Override
	public SimuComWorkflowConfiguration getConfiguration() throws CoreException {
		SimuComWorkflowConfiguration config = new SimuComWorkflowConfiguration();
		
		config.setDebug(this.isDebug);
		if (hasAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION))
			config.setInteractive(getBooleanAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION));
		else
			config.setInteractive(true);
		
		setPCMFilenames(config);
		
		config.setSimulateLinkingResources(getBooleanAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES));
		config.setCleanupCode(getBooleanAttribute(ConstantsContainer.DELETE_PLUGIN));
		config.setPluginID(getStringAttribute(ConstantsContainer.PLUGIN_ID));
		
		config.setSensitivityAnalysisEnabled(
				hasStringAttribute(ConstantsContainer.VARIABLE_TEXT));
		
		config.setSimuComConfiguration(new SimuComConfig(properties, 0, config.isDebug()));
		
		return config;
	}

	private boolean hasAttribute(String attribute) throws CoreException {
		if (!configuration.hasAttribute(attribute))
			return false;
		return true;
	}
	
	private boolean hasStringAttribute(String attribute) throws CoreException {
		if (!configuration.hasAttribute(attribute))
			return false;
		Object value = getStringAttribute(attribute);
		return value instanceof String && !value.equals("");
	}

	private void setPCMFilenames(SimuComWorkflowConfiguration config) throws CoreException {
		
		config.setRepositoryFile   ( getStringAttribute(ConstantsContainer.REPOSITORY_FILE) );
		config.setResourceTypeFile ( getStringAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE) );
		config.setSystemFile       ( getStringAttribute(ConstantsContainer.SYSTEM_FILE) );
		config.setAllocationFile   ( getStringAttribute(ConstantsContainer.ALLOCATION_FILE) );
		config.setUsageModelFile   ( getStringAttribute(ConstantsContainer.USAGE_FILE) );
		config.setFeatureConfigFile( getStringAttribute(ConstantsContainer.FEATURE_CONFIG) );
		config.setMiddlewareFile   ( getStringAttribute(ConstantsContainer.MWREPOSITORY_FILE) );

	}

	private String getStringAttribute(String attribute) throws CoreException {
		ensureAttributeExists(attribute);
		Object value = configuration.getAttribute(attribute, "");
		if (!(value instanceof String))
			throw new IllegalArgumentException("Tried to read non-string value as string value");

		return (String)value;
	}
	
	private Boolean getBooleanAttribute(String attribute) throws CoreException {
		if (!hasAttribute(attribute))
			return false;
		
		Object value = configuration.getAttribute(attribute, false);
		if (!(value instanceof Boolean))
			throw new IllegalArgumentException("Tried to read non-boolean value as boolean value");

		return (Boolean)value;
	}

	private void ensureAttributeExists(String attribute) throws CoreException {
		if (!configuration.hasAttribute(attribute))
			throw new IllegalStateException("Tried to read non-existing configuration attribute");
	}
	
}
