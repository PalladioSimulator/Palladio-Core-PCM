package de.uka.ipd.sdq.workflow.launchconfig.configbuilder;

import java.util.Map;

import de.uka.ipd.sdq.workflow.AbstractJobConfiguration;

/**
 * Base class for all builder classes which take an Eclipse ILaunchConfig or its contained attributes
 * map and convert it into a configuration object of the ConfigurationType
 * @author Snowball
 *
 * @param <ConfigurationType> Type of the configuration object this builder is going to build
 */
public abstract class AbstractUIBasedConfigurationBuilder
	<ConfigurationType extends AbstractJobConfiguration> {

	/**
	 * Key-value pairs of the configuration options set in the run dialog
	 */
	private Map<String,Object> attributes = null;

	/**
	 * Constructor of the configuration object builder
	 * @param attributes The key-value pairs used to configure the produced object
	 */
	public AbstractUIBasedConfigurationBuilder(Map<String,Object> attributes) {
		super();
		
		this.attributes = attributes;
	}
	
	/**
	 * Builds the configuration object
	 * @return A configuration object containing the typed configuration options
	 */
	public ConfigurationType build() {
		return internalBuild(attributes);
	}
	
	/** 
	 * Called as template method to fill the given object according to the provided map
	 * @param objectToFill The object in which to set the configuration options
	 * @param attributes The map to use for filling the configuration options
	 */
	abstract protected ConfigurationType internalBuild(Map<String,Object> attributes);
}