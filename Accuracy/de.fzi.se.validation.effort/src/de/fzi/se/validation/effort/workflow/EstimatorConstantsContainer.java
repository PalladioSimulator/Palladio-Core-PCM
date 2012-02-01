/**
 *
 */
package de.fzi.se.validation.effort.workflow;

/**This class is used as a container for constants related to validation effort estimation.
 *
 * @author groenda
 *
 */
public class EstimatorConstantsContainer {
	// launch configuration attributes
	/** Identifier used to access the configuration attribute for the repository file. */
	public static final String REPOSITORY_FILE = "repositoryFile";
	/** Identifier used to access the configuration attribute for the behaviour location. */
	public static final String BEHAVIOUR_URI = "behaviourURI";
	/** Identifier used to access the configuration attribute for the confidence level. */
	public static final String CONFIDENCE = "confidence";

	// default values
	/** Default URI of the repository file. */
	public static final String DEFAULT_REPOSITORY_FILE = "";
	/** Default URI of the behaviour location. */
	public static final String DEFAULT_BEHAVIOUR_URI = "";
	/** Default confidence level. */
	public static final Double DEFAULT_CONFIDENCE = 0.9;

	// Extension point references
	/** Extension point ID where effort estimators are registered. */
	public static final String EXTENSION_POINT_ID = "de.fzi.se.validation.effort.estimation";
	/** Attribute of extension schema for estimator class. */
	public static final String EXTENSION_POINT_ATTRIBUTE_ESTIMATOR = "estimator";
	/** Attribute of extension schema for criterion name. */
	public static final String EXTENSION_POINT_ATTRIBUTE_CONFIGURATION_TAB = "configurationTab";

}
