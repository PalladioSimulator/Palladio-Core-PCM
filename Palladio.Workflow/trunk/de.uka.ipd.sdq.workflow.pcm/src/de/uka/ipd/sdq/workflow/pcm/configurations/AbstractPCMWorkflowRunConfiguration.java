package de.uka.ipd.sdq.workflow.pcm.configurations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.workflow.exceptions.InvalidWorkflowJobConfiguration;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowFailedException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

/**
 * Base class of workflow configuration objects where the workflow has to deal with a PCM model instance. This
 * configuration class holds the locations of the PCM model parts, and (for convinience) a static list 
 * of EPackages needed to read the files.
 * 
 * @author Steffen Becker
 */
public abstract class AbstractPCMWorkflowRunConfiguration 
extends	AbstractWorkflowBasedRunConfiguration {
	
	/**
	 * Convinience field containing all PCM EPackages. Handy for loading PCM model files as it is needed to
	 * configure the loading resource set. 
	 */
	public static final EPackage[] PCM_EPACKAGES = new EPackage[]{
			SeffPackage.eINSTANCE,
			RepositoryPackage.eINSTANCE,
			ParameterPackage.eINSTANCE,
			UsagemodelPackage.eINSTANCE,
			SystemPackage.eINSTANCE,
			ResourcetypePackage.eINSTANCE,
			ResourceenvironmentPackage.eINSTANCE,
			AllocationPackage.eINSTANCE,
			StoexPackage.eINSTANCE,
			CorePackage.eINSTANCE,
			CompletionsPackage.eINSTANCE,
		};
	
	private String resourceTypeFile;
	private String repositoryFile;
	private String middlewareFile;
	private String systemFile;
	private String allocationFile;
	private String usageModelFile;
	private String featureConfigFile;

	/**
	 * @return Returns a list of string URIs containing all model files needed for a full PCM instance
	 */
	public List<String> getPCMModelFiles() {
		ArrayList<String> files = new ArrayList<String>();
		files.add(this.resourceTypeFile);
		files.add(this.repositoryFile);
		files.add(systemFile);
		files.add(allocationFile);
		files.add(usageModelFile);
		
		// TODO: Temporary workaround, this should be moved to its own config object
		if (featureConfigFile != null)
			files.add(featureConfigFile);
		return files;
	}

	/**
	 * @return Returns the filename of the PCM resource type model
	 */
	public String getResourceTypeFile() {
		return resourceTypeFile;
	}

	/** Sets the PCM resource type model file name
	 * @param resourceTypeFile The resource type model file name
	 */
	public void setResourceTypeFile(String resourceTypeFile) {
		checkFixed();
		this.resourceTypeFile = resourceTypeFile;
	}

	/**
	 * @return Returns the PCM repository's file name
	 */
	public String getRepositoryFile() {
		return repositoryFile;
	}

	/** Sets the PCM repository's file name
	 * @param repositoryFile The PCM repository file name
	 */
	public void setRepositoryFile(String repositoryFile) {
		checkFixed();
		this.repositoryFile = repositoryFile;
	}

	/**
	 * @return Returns the filename of the PCM's middleware completion repository
	 */
	public String getMiddlewareFile() {
		return middlewareFile;
	}

	/** Sets the filename of the PCM's middleware completion repository
	 * @param middlewareFile
	 */
	public void setMiddlewareFile(String middlewareFile) {
		checkFixed();
		this.middlewareFile = middlewareFile;
	}

	public String getSystemFile() {
		return systemFile;
	}

	public void setSystemFile(String systemFile) {
		checkFixed();
		this.systemFile = systemFile;
	}

	public String getAllocationFile() {
		return allocationFile;
	}

	public void setAllocationFile(String allocationFile) {
		checkFixed();
		this.allocationFile = allocationFile;
	}

	public String getUsageModelFile() {
		return usageModelFile;
	}

	public void setUsageModelFile(String usageModelFile) {
		checkFixed();
		this.usageModelFile = usageModelFile;
	}

	/**
	 * @return Returns the filename of the mark model instance containing the PCM connector completion configuration
	 */
	public String getFeatureConfigFile() {
		return featureConfigFile;
	}

	/** Sets the filename of the mark model for connector completions
	 * @param featureConfigFile File name of the connector completion file
	 */
	public void setFeatureConfigFile(String featureConfigFile) {
		checkFixed();
		this.featureConfigFile = featureConfigFile;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration#validateAndFreeze()
	 */
	@Override
	public void validateAndFreeze() throws InvalidWorkflowJobConfiguration {
		super.validateAndFreeze();
		for (String fileURI : getPCMModelFiles()) {
			if (fileURI == null)
				throw new InvalidWorkflowJobConfiguration("Workflow configuration is invalid, not all PCM models are set");
			URI fileLocation = URI.createURI(fileURI);
			// TODO: Check whether file exists
		}
	}
}
