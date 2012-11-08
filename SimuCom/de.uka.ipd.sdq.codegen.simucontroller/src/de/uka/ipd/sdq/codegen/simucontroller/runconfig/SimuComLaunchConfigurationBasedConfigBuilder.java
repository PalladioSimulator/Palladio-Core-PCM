package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.WorkflowHooks;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.extension.ExtensionHelper;
import de.uka.ipd.sdq.workflow.launchconfig.extension.WorkflowExtension;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

public class SimuComLaunchConfigurationBasedConfigBuilder extends
        AbstractSimulationLaunchConfigurationBasedConfigBuilder {

    public SimuComLaunchConfigurationBasedConfigBuilder(ILaunchConfiguration configuration, String mode)
            throws CoreException {
        super(configuration, mode);
    }

    @Override
    public void fillConfiguration(AbstractWorkflowBasedRunConfiguration configuration) throws CoreException {
        super.fillConfiguration(configuration);

        SimuComWorkflowConfiguration config = (SimuComWorkflowConfiguration) configuration;
        config.setSimulateFailures(getBooleanAttribute(ConstantsContainer.SIMULATE_FAILURES));

		// accuracy analysis
		config.setAccuracyInfluenceAnalysisEnabled(getBooleanAttribute(ConstantsContainer.ANALYSE_ACCURACY));
		config.setAccuracyInformationModelFile(getStringAttribute(ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE));

		config.setMiddlewareFile   ( getStringAttribute(ConstantsContainer.MWREPOSITORY_FILE) );
		config.setEventMiddlewareFile   ( getStringAttribute(ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE) );
		
        SimuComConfig simuComConfig = new SimuComConfig(properties, config.isDebug());

        // Set SimuCom config extensions based on registered extensions
        for (String workflowHookId : WorkflowHooks.getAllWorkflowHookIDs()) {
	        for (WorkflowExtension<?> workflowExtension : ExtensionHelper.getWorkflowExtensions(workflowHookId)) {
	            if ((workflowExtension.getExtensionConfigurationBuilder() != null)
	                    && (workflowExtension.getExtensionConfigurationBuilder() instanceof SimuComExtensionConfigurationBuilder)) {
	                SimuComConfigExtension simuComConfigExtension = ((SimuComExtensionConfigurationBuilder) workflowExtension
	                        .getExtensionConfigurationBuilder()).deriveSimuComConfigExtension(properties);
	                if (simuComConfigExtension != null) {
	                    simuComConfig.addSimuComConfigExtension(workflowExtension.getId(), simuComConfigExtension);
	                }
	            }
	        }
        }

        config.setSimuComConfiguration(simuComConfig);
    }

}
