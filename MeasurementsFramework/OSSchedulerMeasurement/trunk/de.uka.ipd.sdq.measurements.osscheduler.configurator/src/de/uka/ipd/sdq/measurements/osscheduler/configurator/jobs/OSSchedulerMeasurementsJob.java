package de.uka.ipd.sdq.measurements.osscheduler.configurator.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.measurements.osscheduler.configurator.OSSchedulerMeasurementsConfiguration;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class OSSchedulerMeasurementsJob implements IJob {
	
	public OSSchedulerMeasurementsJob(OSSchedulerMeasurementsConfiguration config) throws CoreException {

	}

	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {

	}

	public String getName() {
		return "OS Scheduler Measurements Job";
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Not needed.
	}

}
