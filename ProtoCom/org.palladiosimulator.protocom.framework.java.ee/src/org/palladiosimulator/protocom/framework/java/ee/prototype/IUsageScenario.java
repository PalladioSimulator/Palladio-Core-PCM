package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The IUsageScenario interface is used to get the data of all usage scenarios in generated performance prototypes.
 * @author Christian Klaussner
 */
public interface IUsageScenario {
	/**
	 * Gets the ID of the usage scenario.
	 * @return the ID of the usage scenario
	 */
	String getId();
	
	/**
	 * Gets the name of the usage scenario.
	 * @return the name of the usage scenario
	 */
	String getName();

	/**
	 * Gets the URL of the generated JMX file.
	 * @return the URL of the JMX file
	 */
	@JsonIgnore
	URL getFileUrl();

	/**
	 * Gets the name of the generated JMX file.
	 * @return the name of the JMX file
	 */
	@JsonIgnore
	String getFileName();
}
