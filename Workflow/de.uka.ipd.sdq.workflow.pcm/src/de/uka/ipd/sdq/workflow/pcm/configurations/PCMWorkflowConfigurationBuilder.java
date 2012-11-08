package de.uka.ipd.sdq.workflow.pcm.configurations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * Builder class which is able to fill the PCM specific parts of a workflow configuration object based on the PCM
 * filename configuration tab entries.
 *
 * @author Steffen Becker
 */
public class PCMWorkflowConfigurationBuilder extends
		AbstractWorkflowConfigurationBuilder {

	/** Constructor of this builder
	 * @param configuration The configuration as created by Eclipse based on the data entered by the user in the
	 * Eclipse Run Dialog
	 * @param mode Either "debug" or "run", passed by Eclipse depending on the used dialog
	 * @throws CoreException
	 */
	public PCMWorkflowConfigurationBuilder(ILaunchConfiguration configuration,
			String mode) throws CoreException {
		super(configuration, mode);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder#fillConfiguration(de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration)
	 */
	@Override
	public void fillConfiguration(
			AbstractWorkflowBasedRunConfiguration configuration)
			throws CoreException {
		AbstractPCMWorkflowRunConfiguration config = (AbstractPCMWorkflowRunConfiguration) configuration;

		setPCMFilenames(config);
		// temporary data location
		config.setStoragePluginID(getStringAttribute(ConstantsContainer.TEMPORARY_DATA_LOCATION));
		config.setDeleteTemporaryDataAfterAnalysis(getBooleanAttribute(ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS));
		// accuracy analysis
		config.setAccuracyInfluenceAnalysisEnabled(ConstantsContainer.DEFAULT_ANALYSE_ACCURACY);
		config.setAccuracyInformationModelFile(ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);
	}

	/** Read the PCM model filenames from this builder's launch configuration
	 * @param config The configuration object to fill with the PCM model filenames
	 * @throws CoreException
	 */
	private void setPCMFilenames(AbstractPCMWorkflowRunConfiguration config) throws CoreException {

		//BRG
		List <String> tempList = new ArrayList <String>();

		tempList.add(getStringAttribute(ConstantsContainer.ALLOCATION_FILE));
		config.setAllocationFiles(tempList);
		config.setUsageModelFile   ( getStringAttribute(ConstantsContainer.USAGE_FILE) );
		config.setMiddlewareFile   (ConstantsContainer.DEFAULT_MIDDLEWARE_REPOSITORY_FILE);
		config.setEventMiddlewareFile   (ConstantsContainer.DEFAULT_EVENT_MIDDLEWARE_FILE);

	}
}
