package org.palladiosimulator.protocom.framework.java.ee.protocol;

/**
 * A Parameter object represents a name-value pair used as GET parameter.
 * @author Christian Klaussner
 */
public class Parameter {
	private String name;
	private String value;
	
	/**
	 * Constructs a new Parameter object.
	 * @param name the name of the parameter
	 * @param value the value of the parameter
	 */
	public Parameter(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the name of the parameter.
	 * @return the name of the parameter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the value of the parameter.
	 * @return the value of the parameter
	 */
	public String getValue() {
		return value;
	}
}
