package org.somox.configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * Configuration Object defining a configuration Element
 * @author Benjamin Klatt
 *
 */
public class ConfigurationDefinition {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	/** The available types for configuration fields */
	public enum Type {DIRECTORY,STRING ,BOOLEAN,CHOICE}

	/** Indicator for an unlimited multiplicity */
	public static int MULIPLICITY_UNLIMITED = -1;

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The identifier for this configuration item */
	private String id = null;

	/** The name for this configuration item */
	private String name = null;

	/** The type for this configuration item */
	private ConfigurationDefinition.Type type = null;

	/** The default value for this configuration item */
	private String defaultValue = null;

	/** The list of possibleValues */
	private List<String> possibleValues = new LinkedList<String>();

	/**
	 * The number of allowed possibleValues.
	 * A value equals to ConfigurationDefinition.MULIPLICITY_UNLIMITED
	 * means an unlimited number of possibleValues is allowed
	 */
	private int multiplicity = 1;

	/** Flag whether this option is required */
	private boolean required = true;


	// ---------------------------------
	// Constructor
	// ---------------------------------

	/**
	 * Constructor requiring the complete set of definitions
	 * @param id	The identifier for the parameter
	 * @param name	The name of the parameter
	 * @param type	The type of the parameter
	 * @param defaultValue	The defaultValue
	 * @param possibleValues	The possible values for this configuration
	 * @param multiplicity	The maximum number of possibleValues for this configuration
	 * @param required	Flag whether this configuration is required
	 */
	public ConfigurationDefinition(	String id,
									String name,
									ConfigurationDefinition.Type type,
									String defaultValue,
									List<String> possibleValues,
									int multiplicity,
									boolean required) {
		this(id, name, type, defaultValue);
		this.possibleValues = possibleValues;
		this.multiplicity = multiplicity;
		this.setRequired(required);
	}

	/**
	 * Constructor requiring the basic information and the default value
	 * @param id	The identifier for the parameter
	 * @param name	The name of the parameter
	 * @param type	The type of the parameter
	 * @param defaultValue	The defaultValue
	 */
	public ConfigurationDefinition(String id, String name, ConfigurationDefinition.Type type, String defaultValue) {
		this(id, name, type);
		this.defaultValue = defaultValue;
	}

	/**
	 * Constructor requiring the basic information and the default value
	 * @param id	The identifier for the parameter
	 * @param name	The name of the parameter
	 * @param type	The type of the parameter
	 * @param defaultValue	The defaultValue
	 * @param required	Flag whether this configuration is required
	 */
	public ConfigurationDefinition(String id, String name, ConfigurationDefinition.Type type, String defaultValue, boolean required) {
		this(id, name, type, defaultValue);
		this.setRequired(required);
	}

	/**
	 * Constructor requiring the minimum of definitions
	 * @param id	The identifier for the parameter
	 * @param name	The name of the parameter
	 * @param type	The type of the parameter
	 */
	public ConfigurationDefinition(String id, String name, ConfigurationDefinition.Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public ConfigurationDefinition.Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ConfigurationDefinition.Type type) {
		this.type = type;
	}

	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @param possibleValues the possibleValues to set
	 */
	public void setPossibleValues(List<String> possibleValues) {
		this.possibleValues = possibleValues;
	}

	/**
	 * @return the possibleValues
	 */
	public List<String> getPossibleValues() {
		return possibleValues;
	}

	/**
	 * @param multiplicity the multiplicity to set
	 */
	public void setMultiplicity(int multiplicity) {
		this.multiplicity = multiplicity;
	}

	/**
	 * @return the multiplicity
	 */
	public int getMultiplicity() {
		return multiplicity;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}
}
