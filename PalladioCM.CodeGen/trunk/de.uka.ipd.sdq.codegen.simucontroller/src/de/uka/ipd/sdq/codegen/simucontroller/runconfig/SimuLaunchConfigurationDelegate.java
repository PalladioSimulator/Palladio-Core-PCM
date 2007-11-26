package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.MultipleSimulationRunsCompositeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimulationRunCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;

/**
 * The class adapts defined functionality in the LaunchConfigurationDelegate for
 * SimuCom Framework.
 * 
 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate
 * 
 * @author Roman Andrej
 */
public class SimuLaunchConfigurationDelegate extends
		LaunchConfigurationDelegate<SimuAttributesGetMethods> {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#creataAttributesGetMethods(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	protected SimuAttributesGetMethods creataAttributesGetMethods(
			ILaunchConfiguration configuration) {
		return new SimuAttributesGetMethods(configuration);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#createRunCompositeJob(de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
	 */
	@Override
	protected IJob createRunCompositeJob(SimuAttributesGetMethods attributes)
			throws JobFailedException, CoreException {
		if (!attributes.getOAWWorkflowProperties().get(ConstantsContainer.VARIABLE_TEXT).equals("") ) {
			return new MultipleSimulationRunsCompositeJob(attributes);
		} else {
			return new SimulationRunCompositeJob(attributes);
		}
	}


}
