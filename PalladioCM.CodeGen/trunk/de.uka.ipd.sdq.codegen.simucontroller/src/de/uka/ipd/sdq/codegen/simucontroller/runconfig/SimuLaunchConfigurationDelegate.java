package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimulationRunCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * The class adapts defined functionality in the LaunchConfigurationDelegate for
 * SimuCom Framework.
 * 
 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate
 * 
 * @author Roman Andrej
 */
public class SimuLaunchConfigurationDelegate extends
		LaunchConfigurationDelegate {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#createRunCompositeJob(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	protected IJob createRunCompositeJob(ILaunchConfiguration configuration)
			throws CoreException {
		return new SimulationRunCompositeJob(configuration);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#getTemplateMethod()
	 */
	@Override
	protected String defineTemplateMethod() {
		return "simulation_template_methods";
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#isShouldThrowException(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isShouldThrowException(ILaunchConfiguration configuration)
			throws CoreException {
		return configuration.getAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION,
				false);
	}
}
