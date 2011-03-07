package de.uka.ipd.sdq.workflow.pcm.configurations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;
import de.uka.ipd.sdq.workflow.exceptions.InvalidWorkflowJobConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

/**
 * Base class of workflow configuration objects where the workflow has to deal
 * with a PCM model instance. This configuration class holds the locations of
 * the PCM model parts, and (for convinience) a static list of EPackages needed
 * to read the files.
 * 
 * @author Steffen Becker
 */
public abstract class AbstractPCMWorkflowRunConfiguration extends
		AbstractWorkflowBasedRunConfiguration {
	
	/** URI to the default event middleware model file */
	public static final String PCM_DEFAULT_EVENT_MIDDLEWARE_FILE_URI = "pathmap://PCM_MODELS/default_event_middleware.repository";

	/**
	 * Contains All EPackages within or referenced by PCM. Used, e.g., for OAW
	 * template generation.
	 */
	public static final EPackage[] PCM_EPACKAGES = new EPackage[] {
			// Packages needed by QVT Transformations {{
			EcorePackage.eINSTANCE,
			IdentifierPackage.eINSTANCE,
			UnitsPackage.eINSTANCE,
			ProbfunctionPackage.eINSTANCE,
			PcmPackage.eINSTANCE,
			// }}
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
			ReliabilityPackage.eINSTANCE,
			de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage.eINSTANCE,
			de.uka.ipd.sdq.pcm.seff.reliability.ReliabilityPackage.eINSTANCE, };

	protected String middlewareFile;
	protected String eventMiddlewareFile;
	protected List<String> allocationFiles;
	protected String usageModelFile;

	/**
	 * @return Returns a list of string URIs containing all model files needed
	 *         for a full PCM instance
	 */
	public List<String> getPCMModelFiles() {
		ArrayList<String> files = new ArrayList<String>();
		files.addAll(allocationFiles);
		files.add(usageModelFile);

		return files;
	}

	/**
	 * @return Returns the filename of the PCM's middleware completion
	 *         repository
	 */
	public String getMiddlewareFile() {
		return middlewareFile;
	}

	/**
	 * Sets the filename of the PCM's middleware completion repository
	 * 
	 * @param middlewareFile
	 */
	public void setMiddlewareFile(String middlewareFile) {
		checkFixed();
		this.middlewareFile = middlewareFile;
	}

	/**
	 * @return Returns the filename of the PCM's middleware completion
	 *         repository. If the repository was not set before, the default file will be returned.
	 */
	public String getEventMiddlewareFile() {
		if(eventMiddlewareFile != null){
			return eventMiddlewareFile;
		} else {
			return PCM_DEFAULT_EVENT_MIDDLEWARE_FILE_URI;
		}
	}

	/**
	 * Sets the filename of the PCM's middleware completion repository
	 * 
	 * @param eventMiddlewareFile
	 */
	public void setEventMiddlewareFile(String eventMiddlewareFile) {
		checkFixed();
		this.eventMiddlewareFile = eventMiddlewareFile;
	}

	public List<String> getAllocationFiles() {
		return allocationFiles;
	}

	public void setAllocationFiles(List<String> allocationFile) {
		checkFixed();
		this.allocationFiles = allocationFile;
	}

	public String getUsageModelFile() {
		return usageModelFile;
	}

	public void setUsageModelFile(String usageModelFile) {
		checkFixed();
		this.usageModelFile = usageModelFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration
	 * #validateAndFreeze()
	 */
	@Override
	public void validateAndFreeze() throws InvalidWorkflowJobConfiguration {
		super.validateAndFreeze();
		for (String fileURI : getPCMModelFiles()) {
			if (fileURI == null)
				throw new InvalidWorkflowJobConfiguration(
						"Workflow configuration is invalid, not all PCM models are set");
			URI fileLocation = URI.createURI(fileURI);
			// TODO: Check whether file exists
		}
	}
}
