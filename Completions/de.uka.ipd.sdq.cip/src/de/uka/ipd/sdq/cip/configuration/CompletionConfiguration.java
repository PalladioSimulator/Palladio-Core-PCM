package de.uka.ipd.sdq.cip.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.cip.ConstantsContainer;

public class CompletionConfiguration {
	protected List<Transformation> transformations;
	protected String inputPartitionName;
	protected String projectID;
	protected boolean isDebug;
	
	@SuppressWarnings("unchecked")
	public CompletionConfiguration(Map<String, Object> configuration) {
		try {
			isDebug = (Boolean) configuration.get(ConstantsContainer.COMPLETION_QVT_VERBOSE_LOGGING);
			Collection<String> transformationStrings = (Collection<String>) configuration.get(ConstantsContainer.COMPLETION_CONFIG);
			transformations = new ArrayList<Transformation>();
			for(String configString:transformationStrings)
			{
				Transformation transformation = Transformation.fromDataString(configString);
				if(transformation.isEnabled())
					transformations.add(transformation);
			}
		} catch (Exception e) {
			//throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
		}
	}

	public List<Transformation> getTransformations() {
		return transformations;
	}
	
	public String getInputPartitionName(){
		return inputPartitionName;
	}
	
	public void setInputPartitionName(
			String inputPartitionName) {
		this.inputPartitionName = inputPartitionName;
		
	}
	
	public boolean getDebug() {
		return isDebug;
	}
	
	public String getProjectID() {
		return projectID;
	}
	
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
}
