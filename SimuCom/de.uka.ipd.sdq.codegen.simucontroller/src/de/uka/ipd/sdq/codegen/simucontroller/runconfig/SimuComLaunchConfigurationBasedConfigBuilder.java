package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

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

        SimuComConfig simuComConfig = new SimuComConfig(properties, config.isDebug());

        // Set SimuCom config extensions based on registered extensions
        for (WorkflowExtension workflowExtension : ExtensionHelper.getWorkflowExtensions(getWorkflowId())) {
            if ((workflowExtension.getExtensionConfigurationBuilder() != null)
                    && (workflowExtension.getExtensionConfigurationBuilder() instanceof SimuComExtensionConfigurationBuilder)) {
                SimuComConfigExtension simuComConfigExtension = ((SimuComExtensionConfigurationBuilder) workflowExtension
                        .getExtensionConfigurationBuilder()).deriveSimuComConfigExtension(properties);
                if (simuComConfigExtension != null) {
                    simuComConfig.addSimuComConfigExtension(workflowExtension.getId(), simuComConfigExtension);
                }
            }
        }

        config.setSimuComConfiguration(simuComConfig);
    }
    
    public String getWorkflowId() {
        return "workflow.extension.simucom";
    }

}
