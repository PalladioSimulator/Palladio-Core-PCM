package de.uka.ipd.sdq.workflow.launchconfig;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;


public abstract class AbstractWorkflowConfigurationBuilder {

	protected ILaunchConfiguration configuration;
	protected boolean isDebug;
	protected Map<String, Object> properties;

	
	/**
	 * @param configuration
	 * @param isDebug
	 * @param properties
	 * @throws CoreException 
	 */
	@SuppressWarnings("unchecked")
	public AbstractWorkflowConfigurationBuilder(ILaunchConfiguration configuration,
			String mode) throws CoreException {
		super();
		this.configuration = configuration;
		this.isDebug = mode.equals(ILaunchManager.DEBUG_MODE);
		this.properties = configuration.getAttributes();
	}

	public abstract void fillConfiguration(AbstractWorkflowBasedRunConfiguration configuration) throws CoreException;

	protected boolean hasAttribute(String attribute) throws CoreException {
		if (!configuration.hasAttribute(attribute))
			return false;
		return true;
	}

	protected boolean hasStringAttribute(String attribute) throws CoreException {
		if (!configuration.hasAttribute(attribute))
			return false;
		Object value = getStringAttribute(attribute);
		return value instanceof String && !value.equals("");
	}

	protected String getStringAttribute(String attribute) throws CoreException {
		ensureAttributeExists(attribute);
		Object value = configuration.getAttribute(attribute, "");
		if (!(value instanceof String))
			throw new IllegalArgumentException("Tried to read non-string value as string value");
	
		return (String)value;
	}

	protected double getDoubleAttribute(String attribute) throws CoreException {
		ensureAttributeExists(attribute);
		Object value = configuration.getAttribute(attribute, "");
		if (!(value instanceof String))
			throw new IllegalArgumentException("Tried to read non-double value as double value");
	
		return Double.parseDouble((String) value);
	}

	protected Boolean getBooleanAttribute(String attribute) throws CoreException {
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
