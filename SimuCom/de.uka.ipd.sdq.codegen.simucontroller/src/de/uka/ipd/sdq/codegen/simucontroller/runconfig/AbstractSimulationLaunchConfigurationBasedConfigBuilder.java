package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

public abstract class AbstractSimulationLaunchConfigurationBasedConfigBuilder extends
        AbstractWorkflowConfigurationBuilder {

    public AbstractSimulationLaunchConfigurationBasedConfigBuilder(ILaunchConfiguration configuration, String mode)
            throws CoreException {
        super(configuration, mode);
    }

    @Override
    public void fillConfiguration(AbstractWorkflowBasedRunConfiguration configuration) throws CoreException {
        AbstractSimulationWorkflowConfiguration config = (AbstractSimulationWorkflowConfiguration) configuration;

        config.setCodeGenerationAdvicesFile(CodeGenerationAdvice.SIMULATION);

        config.setDebug(this.isDebug);
        if (hasAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION))
            config.setInteractive(getBooleanAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION));
        else
            config.setInteractive(true);

        config.setSimulateLinkingResources(getBooleanAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES));

        // This loads the feature config for Steffen's Connector Completions
        // TODO: Integrate this in CIP process.
        config.setFeatureConfigFile(getStringAttribute(ConstantsContainer.FEATURE_CONFIG));

        config.setSensitivityAnalysisEnabled(hasValidSensitvityVariableAttribute(ConstantsContainer.VARIABLE_TEXT));
        if (config.isSensitivityAnalysisEnabled()) {
            SensitivityAnalysisConfiguration sensitivityConfig = new SensitivityAnalysisConfiguration(
                    "",
                    // TODO: getStringAttribute(ConstantsContainer.VARIABLE_SHORT_NAME),
                    getStringAttribute(ConstantsContainer.VARIABLE_TEXT),
                    getDoubleAttribute(ConstantsContainer.MINIMUM_TEXT),
                    getDoubleAttribute(ConstantsContainer.MAXIMUM_TEXT),
                    getDoubleAttribute(ConstantsContainer.STEP_WIDTH_TEXT));
            config.setSensitivityAnalysisConfiguration(sensitivityConfig);
        }

    }

    private boolean hasValidSensitvityVariableAttribute(String attribute) throws CoreException {
        if (!configuration.hasAttribute(attribute))
            return false;
        Object value = getStringAttribute(attribute);
        // Anne: I sometimes get a "NO ELEMENT SELECTED" result from the LaunchConfig even if I
        // deleted the string from the field
        // I have no idea how to fix it directly, so I need to catch it here.
        // It seems to only appear in the Design Space Exploration tab.
        return value instanceof String && !value.equals("") && !value.equals("NO ELEMENT SELECTED");
    }

}
