package de.uka.ipd.sdq.measurements.osscheduler.configurator.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.configurator.MeasurementScriptHelper;
import de.uka.ipd.sdq.measurements.osscheduler.configurator.OSSchedulerMeasurementsConfiguration;
import de.uka.ipd.sdq.measurements.osscheduler.experimentseriescontroller.OSSchedulerExperimentSeriesController;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class OSSchedulerMeasurementsJob implements IJob {
	
	private OSSchedulerMeasurementsConfiguration config = null;
	private static final String ExperimentSeriesControllerID = "de.uka.ipd.sdq.measurements.experimentseriescontroller.experimentseriescontroller";
	
	public OSSchedulerMeasurementsJob(OSSchedulerMeasurementsConfiguration config) throws CoreException {
		this.config = config;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		MeasurementScript script = MeasurementScriptHelper.loadMeasurementScript(config.getMeasurementScriptPath());
		IExtensionRegistry registry = Platform.getExtensionRegistry();
        IExtensionPoint extensionPoint = registry.getExtensionPoint(ExperimentSeriesControllerID);
        if (extensionPoint == null)
        {
        	// No extension point found!
        	return;
        }
        IExtension[] extensions = extensionPoint.getExtensions();
        for (int i = 0; i < extensions.length; i++)
        {
            IExtension extension = extensions[i];
            IConfigurationElement[] elements = extension.getConfigurationElements();
            for (int j = 0; j < elements.length; j++)
            {
                try
                {
                    IConfigurationElement element = elements[j];
                    Object o = element.createExecutableExtension("class");
                    if (o instanceof OSSchedulerExperimentSeriesController) {
                    	((OSSchedulerExperimentSeriesController)o).startMeasurements(script, config.getMeasurementsResultsDataSourceId());
                    	break;
                    }
                    
                }
                catch (CoreException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
	}

	public String getName() {
		return "OS Scheduler Measurements Job";
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Not needed.
	}

}
