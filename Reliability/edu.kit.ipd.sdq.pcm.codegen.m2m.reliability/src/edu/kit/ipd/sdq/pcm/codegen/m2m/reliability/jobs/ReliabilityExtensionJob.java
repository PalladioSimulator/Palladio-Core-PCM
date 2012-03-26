package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimuComExtensionJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class ReliabilityExtensionJob extends AbstractSimuComExtensionJob {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	public void execute(final IProgressMonitor monitor)
			throws JobFailedException, UserCanceledException {
		ReliabilityExtensionJobConfiguration configuration = (ReliabilityExtensionJobConfiguration)getJobConfiguration();
		if (configuration.isSimulateFailures()) {
			addCodeGenerationAdvice("simulation_template_methods_reliability");
		}
	}

}
