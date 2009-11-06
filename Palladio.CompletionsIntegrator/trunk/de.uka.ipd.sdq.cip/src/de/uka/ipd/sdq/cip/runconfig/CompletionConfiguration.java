package de.uka.ipd.sdq.cip.runconfig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.completions.CompletionEntry;
import de.uka.ipd.sdq.cip.completions.CompletionType;

public class CompletionConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4413106179557246174L;
	
	private ArrayList<CompletionEntry> completionEntrys = null;
	private String modelPartition;
	private String lastPartition;
	private IProject project;
	private String resourceRepository;
	private String featureConfigFile;
	
	@SuppressWarnings("unchecked")
	public CompletionConfiguration(Map<String,Object> configuration) {
		try {
			HashMap<String,String> completions = (HashMap<String,String>) configuration.get(
					ConstantsContainer.COMPLETION);
			completionEntrys = CompletionType.getCompletionEntrys(completions);
		} catch (Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config", e);
		}
	}

	public void setCompletionEntrys(ArrayList<CompletionEntry> completionEntrys) {
		this.completionEntrys = completionEntrys;
	}

	public ArrayList<CompletionEntry> getCompletionEntrys() {
		return completionEntrys;
	}

	public void setModelPartition(String modelPartition) {
		this.modelPartition = modelPartition;
	}

	public String getModelPartition() {
		return modelPartition;
	}

	public void setLastPartition(String lastResourceSet) {
		this.lastPartition = lastResourceSet;
	}

	public String getLastPartition() {
		return lastPartition;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public IProject getProject() {
		return project;
	}

	public void setResourceRepository(String resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	public String getResourceRepository() {
		return resourceRepository;
	}

	public void setFeatureConfigFile(String featureConfigFile) {
		this.featureConfigFile = featureConfigFile;
	}

	public String getFeatureConfigFile() {
		return featureConfigFile;
	}

}
