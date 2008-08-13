package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;

import de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.MultipleSimulationRunsCompositeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimulationRunCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.jobs.CheckOAWConstraintsJob;

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
	protected SimuAttributesGetMethods createAttributesGetMethods(
			ILaunchConfiguration configuration) {
		return new SimuAttributesGetMethods(configuration);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#createRunCompositeJob(de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
	 */
	@Override
	protected IJob createRunCompositeJob(SimuAttributesGetMethods attributes, boolean isDebug, ILaunch launch)
			throws JobFailedException, CoreException {
		OrderPreservingCompositeJob result = new OrderPreservingCompositeJob();
		
		CheckOAWConstraintsJob checkOAWConstraintsJob = new CheckOAWConstraintsJob(
				attributes.getFiles(), attributes.isShouldThrowException());
		result.addJob(checkOAWConstraintsJob);
		
		/* Check whether a sensitivity analysis is wanted (specified in attribute named 
		 * <code>ConstantsContainer.VARIABLE_TEXT</code>), if yes, start 
		 * multiple runs just changing this one parameter, if not, just start one run.  
		 */
		if (!attributes.getOAWWorkflowProperties(1).get(ConstantsContainer.VARIABLE_TEXT).equals("") ) {
			result.addJob(new MultipleSimulationRunsCompositeJob(attributes));
		} else {
			SimulationRunCompositeJob myJob = new SimulationRunCompositeJob(attributes,isDebug,launch);
			result.addJob(myJob);
		}
		
		return result;
	}


}
