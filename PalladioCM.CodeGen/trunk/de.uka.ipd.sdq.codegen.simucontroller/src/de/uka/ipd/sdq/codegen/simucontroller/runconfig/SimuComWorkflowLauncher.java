package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;

import de.uka.ipd.sdq.codegen.runconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CheckOAWConstraintsJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.MultipleSimulationRunsCompositeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimulationRunCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;

/**
 * The class adapts defined functionality in the LaunchConfigurationDelegate for
 * SimuCom Framework.
 * 
 * @see de.uka.ipd.sdq.codegen.runconfig.AbstractWorkflowBasedLaunchConfigurationDelegate
 * 
 * @author Roman Andrej
 */
public class SimuComWorkflowLauncher 
extends	AbstractWorkflowBasedLaunchConfigurationDelegate<SimuComWorkflowConfiguration> {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#creataAttributesGetMethods(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	protected SimuComWorkflowConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode) throws CoreException {
		SimuComConfigurationBuilder builder = new SimuComLaunchConfigurationBasedConfigBuilder(configuration,mode);
		return builder.getConfiguration();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#createRunCompositeJob(de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
	 */
	@Override
	protected IJob createWorkflowJob(SimuComWorkflowConfiguration config) throws CoreException {
		OrderPreservingCompositeJob result = new OrderPreservingCompositeJob();
		
		result.addJob(new CheckOAWConstraintsJob(
				config.getPCMModelFiles(), !config.isInteractive()));
		
		/* Check whether a sensitivity analysis is wanted (specified in attribute named 
		 * <code>ConstantsContainer.VARIABLE_TEXT</code>), if yes, start 
		 * multiple runs just changing this one parameter, if not, just start one run.  
		 */
		// if (!attributes.getOAWWorkflowProperties(1).get(ConstantsContainer.VARIABLE_TEXT).equals("") ) {
		if (config.isSensitivityAnalysisEnabled()) {
			result.addJob(new MultipleSimulationRunsCompositeJob(config));
		} else {
			result.addJob(new SimulationRunCompositeJob(config));
		}
		
		return result;
	}


}
