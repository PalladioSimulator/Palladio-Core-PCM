/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;

/**Configuration bridge between eclipse launch configuration and workflow engine for validation effort estimation.
 * Creates a {@link EstimatorConfiguration} for a given {@link ILaunchConfiguration}.
 * @author groenda
 *
 */
public class EstimatorConfigurationBuilder extends
		AbstractWorkflowConfigurationBuilder {

	public EstimatorConfigurationBuilder(ILaunchConfiguration configuration, String mode) throws CoreException {
		super(configuration, mode);
	}

	@Override
	public void fillConfiguration(
			AbstractWorkflowBasedRunConfiguration configuration)
			throws CoreException {
		EstimatorConfiguration config = (EstimatorConfiguration) configuration;
		config.setRepositoryFile(getStringAttribute(EstimatorConstantsContainer.REPOSITORY_FILE));
		config.setBehaviourURI(getStringAttribute(EstimatorConstantsContainer.BEHAVIOUR_URI));
		config.setConfidence(Double.parseDouble(getStringAttribute(EstimatorConstantsContainer.CONFIDENCE)));
		config.setInteractive(true);
	}

}
