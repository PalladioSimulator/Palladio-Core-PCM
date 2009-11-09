package de.uka.ipd.sdq.measurements.osscheduler.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.measurements.osscheduler.configurator.OSSchedulerMeasurementsConfiguration;
import de.uka.ipd.sdq.measurements.osscheduler.configurator.jobs.OSSchedulerMeasurementsJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.Workflow;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;

public class OSSchedulerMeasurementsConfigurationDelegate extends
AbstractWorkflowBasedLaunchConfigurationDelegate<OSSchedulerMeasurementsConfiguration, Workflow> {

	@Override
	protected IJob createWorkflowJob(
			OSSchedulerMeasurementsConfiguration config, ILaunch launch)
			throws CoreException {
		return new OSSchedulerMeasurementsJob(config);
	}

	@Override
	protected OSSchedulerMeasurementsConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		OSSchedulerMeasurementsConfiguration config = new OSSchedulerMeasurementsConfiguration();
			
		return config;
	}

}
