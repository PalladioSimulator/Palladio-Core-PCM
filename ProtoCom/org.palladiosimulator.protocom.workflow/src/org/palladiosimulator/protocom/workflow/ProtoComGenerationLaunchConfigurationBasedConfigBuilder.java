package org.palladiosimulator.protocom.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

public class ProtoComGenerationLaunchConfigurationBasedConfigBuilder 
extends
		AbstractWorkflowConfigurationBuilder {

	public ProtoComGenerationLaunchConfigurationBasedConfigBuilder(
			ILaunchConfiguration configuration, String mode) throws CoreException {
		super(configuration,mode);
	}

	@Override
	public void fillConfiguration(AbstractWorkflowBasedRunConfiguration configuration) throws CoreException {
		ProtoComGenerationConfiguration config = (ProtoComGenerationConfiguration) configuration;
		
		config.setDebug(this.isDebug);
		
		config.setSensitivityAnalysisEnabled(
				hasValidSensitvityVariableAttribute(ConstantsContainer.VARIABLE_TEXT));
		if (config.isSensitivityAnalysisEnabled()) {
			SensitivityAnalysisConfiguration sensitivityConfig = 
				new SensitivityAnalysisConfiguration(
						"EJB Sensitivity",
						getStringAttribute(ConstantsContainer.VARIABLE_TEXT), 
						getDoubleAttribute(ConstantsContainer.MINIMUM_TEXT), 
						getDoubleAttribute(ConstantsContainer.MAXIMUM_TEXT), 
						getDoubleAttribute(ConstantsContainer.STEP_WIDTH_TEXT));
			config.setSensitivityAnalysisConfiguration(sensitivityConfig);
		}
		
		String modelToCodeTarget = getStringAttribute(ConstantsContainer.MODEL_TO_TEXT_CHOICE);
		if (ConstantsContainer.MODEL_TO_TEXT_TARGET_JAVA_SE_RMI.equals(modelToCodeTarget)){
			config.setCodeGenerationAdvicesFile(CodeGenerationAdvice.PROTO);
		} else if (ConstantsContainer.MODEL_TO_TEXT_TARGET_JAVA_SE_RMI_STUBS.equals(modelToCodeTarget)) {
			config.setCodeGenerationAdvicesFile(CodeGenerationAdvice.POJO);
		} else {
			config.setCodeGenerationAdvicesFile(CodeGenerationAdvice.EJB3);
		}
		
		
	}
	
	private boolean hasValidSensitvityVariableAttribute(String attribute) throws CoreException {
		if (!configuration.hasAttribute(attribute))
			return false;
		Object value = getStringAttribute(attribute);
		//Anne: I sometimes get a "NO ELEMENT SELECTED" result from the LaunchConfig even if I deleted the string from the field
		//I have no idea how to fix it directly, so I need to catch it here. 
		//It seems to only appear in the Design Space Exploration tab. 
		return value instanceof String && !value.equals("") && !value.equals("NO ELEMENT SELECTED");
	}
	
}
