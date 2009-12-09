package de.uka.ipd.sdq.measurements.osscheduler.ui;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.measurements.osscheduler.configurator.OSSchedulerMeasurementsConfiguration;
import de.uka.ipd.sdq.measurements.osscheduler.configurator.jobs.OSSchedulerMeasurementsJob;
import de.uka.ipd.sdq.workflow.Blackboard;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.ui.UIBasedWorkflow;

public class OSSchedulerMeasurementsConfigurationDelegate extends
AbstractWorkflowBasedLaunchConfigurationDelegate<OSSchedulerMeasurementsConfiguration, UIBasedWorkflow<Blackboard<String>>> {
	
	private static final String LOG_PATTERN = "%-5p: %m\n";

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
		config.setMeasurementScriptPath(configuration.getAttribute(Constants.MEASUREMENTSCRIPT_FILE, ""));
		try {
			config.setMeasurementsResultsDataSourceId(configuration.getAttribute(Constants.MEASUREMENTS_RESULTS_DATASOURCE_ID, -1));
		} catch(CoreException e) {
			OSSchedulerUIPlugin.getDefault().getLog().log(new Status(Status.ERROR, "de.uka.ipd.sdq.measurements.osscheduler.ui", "Invalid Data source specfified."));
			config.setMeasurementsResultsDataSourceId(-1);
		}
		config.setMachineIP(configuration.getAttribute(Constants.MACHINE_IP, ""));
		if (configuration.getAttribute(Constants.USE_MEASUREMENT_SCRIPT, "false").equals("true")) {
			config.setUseMeasurementsScript(true);	
		} else {
			config.setUseMeasurementsScript(false);
		}
		try {
			config.setMachinePort(Integer.parseInt(configuration.getAttribute(Constants.MACHINE_PORT, "0")));
		} catch (NumberFormatException e) {
			config.setMachinePort(0);	
		}
		return config;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate#setupLogging(org.apache.log4j.Level)
	 */
	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel)
			throws CoreException {
		
		ArrayList<LoggerAppenderStruct> loggerList = new ArrayList<LoggerAppenderStruct>();

		loggerList.add(setupLogger("de.uka.ipd.sdq.workflow", logLevel,	LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.measurements", logLevel, LOG_PATTERN));
		return loggerList;
	}	

}
