package de.uka.ipd.sdq.workflow;

import java.util.HashMap;
import java.util.Map;

/**
 * Job configuration which is composed from several child job configurations
 * 
 * @author Snowball
 *
 */
public class AbstractComposedJobConfiguration 
extends AbstractJobConfiguration
implements IJobConfiguration {
	
	private Map<Integer, AbstractJobConfiguration> childConfigurations = new HashMap<Integer,AbstractJobConfiguration>();
	
	@Override
	public String getErrorMessage() {
		String errorMessage = "";
		for (AbstractJobConfiguration config : childConfigurations.values()) {
			if (config.getErrorMessage() != null) {
				errorMessage += config.getErrorMessage();
			}
		}
		return errorMessage.length() == 0 ? null : errorMessage;
	}

	@Override
	public boolean isValid() {
		return getErrorMessage() == null;
	}

	@Override
	public void setDefaults() {
		for (AbstractJobConfiguration config : childConfigurations.values()) {
			config.setDefaults();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (AbstractJobConfiguration config : childConfigurations.values()) {
			builder.append(config.toString()+"\n");
		}
		return builder.toString();
	}

	protected void addChildConfiguration(int id, AbstractJobConfiguration childConfig) {
		childConfigurations.put(id,childConfig);
	}

	protected AbstractJobConfiguration getChildConfiguration(int id) {
		return childConfigurations.get(id);
	}
}
